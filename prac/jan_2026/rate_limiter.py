"""
Rate Limiter: Check if called more than 3 times in the past 3 seconds.

Only one method: returns True if called more than 3 times in last 3 seconds,
otherwise returns False.
"""

# Time:O(1), Space:O(n)

from collections import deque
import time

class RateLimiter:
    def __init__(self):
        self.timestamps = deque()
    
    def check_limit(self) -> bool:
        cur_time = time.time()
        self.timestamps.append(cur_time)

        cutOff = cur_time - 3
        while self.timestamps and self.timestamps[0] < cutOff:
            self.timestamps.popleft()
        
        return len(self.timestamps) > 3

print("Test 1: Normal calls within limit")
limiter = RateLimiter()
print(f"Call 1: {limiter.check_limit()}")  # expect output: False
time.sleep(0.5)
print(f"Call 2: {limiter.check_limit()}")  # expect output: False
time.sleep(0.5)
print(f"Call 3: {limiter.check_limit()}")  # expect output: False
time.sleep(0.5)
print(f"Call 4: {limiter.check_limit()}")  # expect output: True (4 calls in ~1.5s)
print()

print("Test 2: Wait 3 seconds to reset")
time.sleep(3)
print(f"After 3s, Call 1: {limiter.check_limit()}")  # expect output: False
print()

print("Test 3: Rapid calls")
limiter2 = RateLimiter()
print(f"Rapid Call 1: {limiter2.check_limit()}")  # False
print(f"Rapid Call 2: {limiter2.check_limit()}")  # False
print(f"Rapid Call 3: {limiter2.check_limit()}")  # False
print(f"Rapid Call 4: {limiter2.check_limit()}")  # True
print(f"Rapid Call 5: {limiter2.check_limit()}")  # True
