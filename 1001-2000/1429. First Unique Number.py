from typing import List
from collections import defaultdict, deque

class FirstUnique:

    def __init__(self, nums: List[int]):
        self.count = defaultdict(int)
        self.que = deque()
        for x in nums:
            self.add(x)
    
    # O(1)
    def showFirstUnique(self) -> int:
        while self.que and self.count[self.que[0]] > 1:
            self.que.popleft()
        
        return self.que[0] if self.que else -1
    
    # O(1)
    def add(self, value: int) -> None:
        self.count[value] += 1
        self.que.append(value)
