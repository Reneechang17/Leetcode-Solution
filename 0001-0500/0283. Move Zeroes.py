
from typing import *

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        left = 0 # which point to the pos that we should place zero
        for right in range(len(nums)):
            if nums[right] != 0:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1 
