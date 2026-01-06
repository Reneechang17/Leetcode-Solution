# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        cnt = 0
        for x in nums:
            if x < k:
                cnt += 1

        return cnt
    