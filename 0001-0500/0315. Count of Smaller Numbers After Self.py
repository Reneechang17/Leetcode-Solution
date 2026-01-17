# Time:O(nlogn), Space:O(n)

from typing import List
from sortedcontainers import SortedList

class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        res = []
        sorted_list = SortedList()

        for i in range(len(nums) - 1, -1, -1):
            pos = sorted_list.bisect_left(nums[i])
            res.append(pos)
            sorted_list.add(nums[i])
        
        return res[::-1]
    