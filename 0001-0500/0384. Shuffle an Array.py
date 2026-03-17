# Time:O(n), Space:O(n)

import random
from typing import List

class Solution:

    def __init__(self, nums: List[int]):
        self.original = nums[:]
        self.arr = nums[:]

    def reset(self) -> List[int]:
        self.arr = self.original[:]
        return self.arr

    def shuffle(self) -> List[int]:
        for i in range(len(self.arr) - 1, 0, -1):
            j = random.randint(0, i)
            self.arr[i], self.arr[j] = self.arr[j], self.arr[i]
        return self.arr
    