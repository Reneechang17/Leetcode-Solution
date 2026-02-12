# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        max_val = max(nums)
        max_idx = nums.index(max_val)

        second_max = -1
        for num in nums:
            if num != max_val:
                second_max = max(second_max, num)
            
        if max_val >= 2 * second_max:
            return max_idx
            
        return -1