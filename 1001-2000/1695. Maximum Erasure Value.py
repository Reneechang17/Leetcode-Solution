# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        left = 0
        max_sum = 0
        cur_sum = 0
        vis = set()

        for right in range(len(nums)):
            while nums[right] in vis:
                vis.remove(nums[left])
                cur_sum -= nums[left]
                left += 1

            vis.add(nums[right])
            cur_sum += nums[right]
            max_sum = max(max_sum, cur_sum)
        
        return max_sum
    