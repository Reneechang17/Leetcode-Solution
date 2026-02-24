from typing import List

class Solution:
    def tallestBillboard(self, rods: List[int]) -> int:
        rods.sort(reverse=True)
        # total = sum(rods)
        self.ans = 0
        memo = {}
        
        def dfs(i, left, right):
            if i == len(rods):
                if left == right:
                    self.ans = max(self.ans, left)
                return
            
            max_possible = (left + right + sum(rods[i:])) // 2
            if max_possible <= self.ans:
                return
            
            diff = abs(left - right)
            state = (i, diff)
            if state in memo and memo[state] >= min(left, right):
                return
            memo[state] = min(left, right)
            
            dfs(i + 1, left + rods[i], right)
            dfs(i + 1, left, right + rods[i])
            dfs(i + 1, left, right)
        
        dfs(0, 0, 0)
        return self.ans
    