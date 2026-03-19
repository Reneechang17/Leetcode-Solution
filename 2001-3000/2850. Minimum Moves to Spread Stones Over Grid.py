# Time:O(n! × n), Space:O(n)

from typing import List

class Solution:
    def minimumMoves(self, grid: List[List[int]]) -> int:
        sources = [] # 多石頭的位置
        targets = [] # 少石頭的位置

        for i in range(3):
            for j in range(3):
                if grid[i][j] > 1:
                    # 多出grid[i][j]-1個石頭
                    for _ in range(grid[i][j] - 1):
                        sources.append((i, j))
                elif grid[i][j] == 0:
                    targets.append((i, j))
        
        n = len(sources)
        used = [False] * n
        self.ans = float('inf')

        def dfs(idx, steps):
            if idx == n:
                self.ans = min(self.ans, steps)
                return 
            if steps >= self.ans:
                return
            
            for i in range(n):
                if not used[i]:
                    used[i] = True
                    dist = abs(sources[idx][0] - targets[i][0]) + abs(sources[idx][1] - targets[i][1])
                    dfs(idx + 1, steps + dist)
                    used[i] = False
        
        dfs(0, 0) # 當前處理的第idx個多出來的石頭, steps
        return self.ans
    