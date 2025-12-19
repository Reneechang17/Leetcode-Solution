# Time:O(mn*(m+n)), Space:O(n+m)

from typing import List

class Solution:
    def maximumInvitations(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        matches = [-1] * n

        # find a match for boy i
        def dfs(boy, vis):
            for girl in range(n):
                if grid[boy][girl] == 1 and not vis[girl]:
                    vis[girl] = True
                    if matches[girl] == -1 or dfs(matches[girl], vis):
                        matches[girl] = boy
                        return True
            return False
        
        res = 0
        for boy in range(m):
            vis = [False] * n
            if dfs(boy, vis):
                res += 1
        return res
    