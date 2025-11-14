# Because we can’t switch modes in the mid, each mode has the same per-step weight. So run a separate BFS for each mode to get the fewest steps from S to D, then multiply by that mode’s time/cost per block.

from collections import deque
from typing import *

# Time:O(M*R*C), Space:O(R*C)

def find_fastest_transportation(grid: List[List[str]], time: List[int], cost: List[int]) -> int:
    # goal: minimize the time, if same, find the cheapest cost
    m, n = len(grid), (len(grid[0]) if grid else 0)
    if m == 0 or n == 0:
        return -1
    
    # find the S and D
    src = dst = None
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 'S':
                src = (i, j)
            elif grid[i][j] == 'D':
                dst = (i, j)
    if src is None or dst is None:
        return -1
    
    if src == dst:
        # choose the cheapest and min time 
        return min(range(1, M+1), key=lambda m:(time[m-1], cost[m-1], m))
    
    M = len(time) # number of modes(mode ids are 1...M)

    def in_bounds(x: int, y: int) -> bool:
        return 0 <= x < m and 0 <= y < n
    
    def can_enter(x: int, y: int, mode: int) -> bool:
        # check if (x, y) could be enter with that mode
        c = grid[x][y]
        if c == 'X':
            return False
        if c in ('S', 'D'):
            return True
        return c == str(mode)
    
    def bfs_steps_for_mode(mode: int) -> Optional[int]:
        # calculate the min steps from S to D
        sx, sy = src
        if not can_enter(sx, sy, mode):
            return None
        
        que = deque([(sx, sy, 0)]) # (x, y, steps)
        vis = [[False] * n for _ in range(m)]
        vis[sx][sy] = True

        while que:
            x, y, d = que.popleft()
            if (x, y) == dst:
                return d # first arrive
            for dx, dy in ((1,0),(-1,0),(0,1),(0,-1)):
                nx, ny = x + dx, y + dy
                if in_bounds(nx, ny) and not vis[nx][ny] and can_enter(nx, ny, mode):
                    vis[nx][ny] = True
                    que.append((nx, ny, d + 1))
        return None
    
    best_mode, best_time, best_cost = -1, float('inf'), float('inf')
    for mode in range(1, M + 1):
        steps = bfs_steps_for_mode(mode)
        if steps is None:
            continue
        total_time = steps * time[mode - 1]
        total_cost = steps * cost[mode - 1]
        if (total_time < best_time) or (total_time == best_time and total_cost < best_cost):
            best_mode, best_time, best_cost = mode, total_time, total_cost
    
    return best_mode

# Followup: if we accept switch mode mid-way, we can build the status with(x,y,mode)
# and set cost as weight, use Dijkstra to find the shortest time.