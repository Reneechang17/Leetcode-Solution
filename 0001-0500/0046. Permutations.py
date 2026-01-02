# Time:O(n! * n),Space:O(n)

from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtracking(path):
            if len(path) == len(nums):
                res.append(path[:])
                return

            for x in nums:
                if x in path:
                    continue

                path.append(x)
                backtracking(path)
                path.pop()

        backtracking([])
        return res
