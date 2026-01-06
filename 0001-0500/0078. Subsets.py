# Time:O(n * 2^n), Space:O(n)

from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def backtracking(index, path):
            res.append(path[:])

            for i in range(index, len(nums)):
                path.append(nums[i])
                backtracking(i + 1, path)
                path.pop()

        backtracking(0, [])
        return res
    