
from collections import deque

class HitCounter:

    def __init__(self):
        self.que = deque()

    def hit(self, timestamp: int) -> None:
        self.que.append(timestamp)

    def getHits(self, timestamp: int) -> int:
        while self.que and self.que[0] <= timestamp - 300:
            self.que.popleft()
        
        return len(self.que)
