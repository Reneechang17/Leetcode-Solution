# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def findSubarrays(self, nums: List[int]) -> bool:
        vis = set()
        for i in range(len(nums) - 1):
            s = nums[i] + nums[i + 1]
            if s in vis:
                return True
            vis.add(s)
        return False
