# Time:O(max_area), Space:O(max_area)

from collections import deque
from typing import List

class Solution:
    def isEscapePossible(self, blocked: List[List[int]], source: List[int], target: List[int]) -> bool:
        if not blocked:
            return True
        
        blocked_set = set((x, y) for x, y in blocked)
        n = len(blocked)
        max_area = n * (n - 1) // 2

        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        limit = 10**6

        def bfs(start, end):
            que = deque([(start[0], start[1])])
            vis = set()
            vis.add((start[0], start[1]))

            while que and len(vis) <= max_area:
                x, y = que.popleft()
                if (x, y) == (end[0], end[1]):
                    return True
                
                for dx, dy in dirs:
                    nx, ny = x + dx, y + dy
                    if 0 <= nx < limit and 0 <= ny < limit:
                        if (nx, ny) not in blocked_set and (nx, ny) not in vis:
                            vis.add((nx, ny))
                            que.append((nx, ny))
            
            return len(vis) > max_area

        
        return bfs(source, target) and bfs(target, source)
    