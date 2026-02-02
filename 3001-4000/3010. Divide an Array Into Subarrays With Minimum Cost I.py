# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        a = b = float('inf')
        for x in nums[1:]:
            if x < a:
                b = a
                a = x
            elif x < b:
                b = x
        
        return nums[0] + a + b
    