# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_count = 0
        cur = 0

        for num in nums:
            if num == 1:
                cur += 1
                max_count = max(max_count, cur)
            else:
                cur = 0

        return max_count
