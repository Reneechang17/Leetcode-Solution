# Time:O(n! * n), Space:O(n)

from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        used = [False] * len(nums)

        def backtracking():
            if len(path) == len(nums):
                res.append(path[:])
                return
            
            for i in range(len(nums)):
                if not used[i]:
                    used[i] = True
                    path.append(nums[i])
                    backtracking()
                    path.pop()
                    used[i] = False

        backtracking()
        return res
