# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        n = len(nums)
        total_ones = sum(nums)

        if total_ones == 0 or total_ones == n:
            return 0
        
        double = nums + nums

        zeros = 0
        for i in range(total_ones):
            if double[i] == 0:
                zeros += 1
        
        min_swaps = zeros

        for i in range(total_ones, len(double)):
            if double[i - total_ones] == 0:
                zeros -= 1
            if double[i] == 0:
                zeros += 1
            min_swaps = min(min_swaps, zeros)
        
        return min_swaps
    