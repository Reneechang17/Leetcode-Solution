# Time:O(n! * n),Space:O(n)

from typing import List

class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        res = []
        nums.sort()
        vis = [False] * len(nums)

        def backtracking(path):
            if len(path) == len(nums):
                res.append(path[:])
                return

            for i in range(len(nums)):
                if vis[i]:
                    continue

                if i > 0 and nums[i] == nums[i - 1] and not vis[i - 1]:
                    continue

                vis[i] = True
                path.append(nums[i])
                backtracking(path)
                path.pop()
                vis[i] = False

        backtracking([])
        return res
