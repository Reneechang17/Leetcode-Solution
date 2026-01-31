'''
Rate Limiter: Check if called more than 3 times in past 3 seconds
'''

import time
from collections import deque

# Time:O(1), Space:O(k)
class CallTracker:
    def __init__(self):
        self.call_ts = deque()
    
    def is_over_limit(self) -> bool:
        cur_time = time.time()

        self.call_ts.append(cur_time)

        while self.call_ts and self.call_ts[0] < cur_time - 3:
            self.call_ts.popleft()
        
        return len(self.call_ts) > 3

if __name__ == "__main__":
    tracker = CallTracker()
    
    print("Testing 4 rapid calls:")
    results = []
    for i in range(4):
        results.append(tracker.is_over_limit())
        time.sleep(0.001)  
    
    print(f"Results: {results}")
    print(f"Expected: [False, False, False, True]")
    
    print(f"\nTimestamps count: {len(tracker.call_ts)}")
    print(f"Timestamps: {tracker.call_ts}")
