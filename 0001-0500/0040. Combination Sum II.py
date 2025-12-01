# Medium
# Backtracking
# Time:O(2^n), Space:O(n)
# https://leetcode.cn/problems/combination-sum-ii

from typing import *

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def backtracking(start, path, cur_sum):
            if cur_sum == target:
                res.append(path[:])
                return
            
            if cur_sum > target:
                return
            
            # check dup
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                
                path.append(candidates[i])
                backtracking(i + 1, path, cur_sum + candidates[i])
                path.pop()
        
        backtracking(0, [], 0)
        return res
    