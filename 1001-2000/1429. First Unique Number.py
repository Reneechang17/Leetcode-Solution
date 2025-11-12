# Medium
# OrderDict
# https://leetcode.cn/problems/first-unique-number/

from typing import *
from collections import Counter

class FirstUnique:
    
    def __init__(self, nums: List[int]):
        self.dict = {}
        self.cnt = Counter(nums)
        for x in nums:
            if self.cnt[x] == 1:
                self.dict[x] = None

    def showFirstUnique(self) -> int:
        return next(iter(self.dict)) if self.dict else -1

    def add(self, value: int) -> None:
        if self.cnt[value] == 0:
            self.dict[value] = None
        elif self.cnt[value] == 1:
            self.dict.pop(value, None)
        self.cnt[value] += 1
