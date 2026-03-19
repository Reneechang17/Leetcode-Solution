# Time:O(C(9, k) × k), Space:O(k)

from typing import List

class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        path = []

        def backtracking(start, target):
            if len(path) == k and target == 0:
                res.append(path[:])
                return
            
            # pruning
            if len(path) == k or target < 0:
                return
            
            for i in range(start, 10):
                if 10 - i < k - len(path):
                    # no enough number to form k
                    break
                
                path.append(i)
                backtracking(i + 1, target - i)
                path.pop()

        backtracking(1, n)
        return res
    