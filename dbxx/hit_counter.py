# lc 362: https://leetcode.cn/problems/design-hit-counter/

# use deque to store timestamp, add by hit(), clean before 300s by getHits()

from collections import deque

class HitCounter:
    
    def __init__(self):
        self.que = deque()
        
    # Time:O(1), Space:O(n)
    def hit(self, timestamp: int) -> None:
        self.que.append(timestamp)

    # Time:O(1), Space:O(n)
    def getHits(self, timestamp: int) -> int:
        while self.que and self.que[0] <= timestamp - 300:
            self.que.popleft()
        
        return len(self.que)
    
    # follow up: calculate QPS
    # Time:O(1), Space:O(n)
    def getQPS(self, timestamp: int) -> float:
        while self.que and self.que[0] <= timestamp - 300:
            self.que.popleft()

        if not self.que:
            return 0.0
        
        # QPS: total request / time window
        time_range = timestamp - self.que[0] + 1 # +1 incl 2 side
        return len(self.quq) / min(time_range, 300)
    
# follow-up: high QPS optimization
# use fixed arr hits[300], hits[t % 300] store the hit count for that second
# Time:O(1), Space:O(300)->O(1)
class HitCounter2:
    
    def __init__(self):
        self.times = [0] * 300 # store timestamp
        self.hits = [0] * 300 # store hits for that second
        
    def hit(self, timestamp: int) -> None:
        idx = timestamp % 300
        if self.times[idx] != timestamp:
            # reset
            self.times[idx] = timestamp
            self.hits[idx] = 1
        else:
            self.hits[idx] += 1

    def getHits(self, timestamp: int) -> int:
        total = 0
        for i in range(300):
            if timestamp - self.times[i] < 300:
                total += self.hits[i]
        return total
