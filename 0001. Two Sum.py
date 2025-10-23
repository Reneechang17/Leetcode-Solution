# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # {value, index}
        vis = {}
        for i, num in enumerate(nums):
            tmp = target - num
            if tmp in vis:
                return [vis[tmp], i]
            vis[num] = i
        return []
