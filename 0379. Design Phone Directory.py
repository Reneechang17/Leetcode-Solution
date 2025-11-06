# Medium
# Set, Queue
# Time:O(1), Space:O(maxNumber) 
# https://leetcode.cn/problems/design-phone-directory/

from collections import deque

class PhoneDirectory:

    def __init__(self, maxNumbers: int):
        self.available = set(range(maxNumbers))
        self.que = deque(range(maxNumbers))
    
    def get(self) -> int:
        if not self.que:
            return -1
        x = self.que.popleft()
        self.available.remove(x)
        return x

    def check(self, number: int) -> bool:
        return number in self.available

    def release(self, number: int) -> None:
        if number not in self.available:
            self.available.add(number)
            self.que.append(number)
