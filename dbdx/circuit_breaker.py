# implement a counter type circuit breaker with CLOSED->OPEN->HALF_OPEN state machine.
# if CLOSED continue failing to threshold -> OPEN
# and directly reject and count it within OPEN, hit the threshold then HALF_OPEN
# only one detection in HALF -> success to CLOSED; fail to OPEN

from typing import *

class CircuitBreaker:
    def __init__(self, fail_threshold=3, rej_threshold=5):
        self.fail_threshold = fail_threshold
        self.rej_threshold = rej_threshold
        self.state = "CLOSED" # CLOSED, OPEN, HALF_OPEN
        self.fail_count = 0 # only count in CLOSED
        self.rej_count = 0 # only count in OPEN
        self.half_open_used = False

    def call(self, fn, *args, **kwargs):
        # OPEN: directly rej, turn HALF_OPEN when hit threshold
        if self.state == "OPEN":
            self.rej_count += 1
            if self.rej_count >= self.rej_threshold:
                self.state = "HALF_OPEN"
                self.half_open_used = False
            return (False, "open")
        
        # HALF_OPEN
        if self.state == "HALF_OPEN":
            if self.half_open_used:
                # cur detection used
                return (False, "half-open-wait")
            self.half_open_used = True
            try:
                res = fn(*args, **kwargs)
                # success: close, reset counter
                self.state = "CLOSED"
                self.fail_count = 0
                self.rej_count = 0
                return (True, res)
            except Exception:
                # fail: back to OPEN, reset rej_cnt
                self.state = "OPEN"
                self.rej_count = 0
                return (False, "probe-fail")
        
        # CLOSED
        try:
            res = fn(*args, **kwargs)
            self.rej_count = 0
            return (True, res)
        except Exception:
            self.fail_count += 1
            if self.fail_count >= self.fail_threshold:
                self.state = "OPEN"
                self.rej_count = 0
            return(False, "fail")

class FailoverClient:
    def __init__(self, primary_breaker=None, secondary_breaker=None):
        self.primary = primary_breaker or CircuitBreaker()
        self.secondary = secondary_breaker or CircuitBreaker()
    
    def call(self, primary_fn, secondary_fn, *args, **kwargs):
        ok, val = self.primary.call(primary_fn, *args, **kwargs)
        if ok:
            return (True, val) # primary success
        
        ok2, val2 = self.secondary.call(secondary_fn, *args, **kwargs)
        if ok2:
            return (True, val2)
        
        return (False, f"primary:{val}, secondary:{val2}")
            