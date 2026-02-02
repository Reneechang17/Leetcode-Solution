# Time:O(2ⁿ), Space:O(n)

from typing import List

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []

        def backtracking(start, path, cur_sum):
            if cur_sum == target:
                res.append(path[:])
                return
            
            if cur_sum > target:
                return
            
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i - 1]:
                    continue
                
                path.append(candidates[i]) # choose cur
                backtracking(i + 1, path, cur_sum + candidates[i])
                path.pop()

        backtracking(0, [], 0)
        return res
    