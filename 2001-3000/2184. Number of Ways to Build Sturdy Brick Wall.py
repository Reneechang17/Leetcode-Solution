# Time:O(height × n²), Space:O(n²)

from typing import List

class Solution:
    def buildWall(self, height: int, width: int, bricks: List[int]) -> int:
        MOD = 10**9 + 7

        patterns = []

        def dfs(cur_width, gaps):
            if cur_width == width:
                patterns.append(set(gaps))
                return 
            if cur_width > width:
                return
            for b in bricks:
                new_width = cur_width + b
                if new_width > width:
                    continue
                new_gaps = gaps.copy()
                if new_width != width:
                    new_gaps.add(new_width)
                dfs(new_width, new_gaps)

        dfs(0, set())

        if not patterns:
            return 0
        
        n = len(patterns)
        adj = [[] for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if not patterns[i] & patterns[j]:
                    adj[i].append(j)
        
        dp = [1] * n

        for _ in range(1, height):
            new_dp = [0] * n
            for i in range(n):
                for j in adj[i]:
                    new_dp[j] = (new_dp[j] + dp[i]) % MOD
            dp = new_dp
        
        return sum(dp) % MOD
