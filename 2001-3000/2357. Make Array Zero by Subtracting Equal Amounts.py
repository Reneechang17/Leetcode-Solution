# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        pos = set()
        for x in nums:
            if x > 0:
                pos.add(x)

        return len(pos)
