# Time:O(4^n / √n), Space:O(n)

from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []

        def backtracking(cur, left, right):
            if len(cur) == 2 * n:
                res.append(cur)
                return
            
            if left < n:
                backtracking(cur + '(', left + 1, right)
            
            if right < left:
                backtracking(cur + ')', left, right + 1)
        
        backtracking('', 0, 0)
        return res
    