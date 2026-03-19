# Time:O(2ⁿ × n), Space:O(n)

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []

        def backtracking(start):
            res.append(path[:])
            
            for i in range(start, len(nums)):
                path.append(nums[i])
                backtracking(i + 1)
                path.pop()
                
        backtracking(0)
        return res
    