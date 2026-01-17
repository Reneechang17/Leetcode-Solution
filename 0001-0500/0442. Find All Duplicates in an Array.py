# Time:O(n), Space:O(1)

from typing import *

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []

        for num in nums:
            index = abs(num) - 1 # 1-index

            if nums[index] < 0:
                # already neg -> meet before
                res.append(abs(num))
            else:
                # turn it to neg when first meet this element
                nums[index] = -nums[index]
        
        return res
    