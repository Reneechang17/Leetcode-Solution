"""
Desert Car to Oasis Shortest Path

Given a 2D grid where:
- 'c' represents the car (start)
- 'o' represents the oasis (destination)
- other cells are passable

Find the shortest path from car to oasis.

Follow-up 1: Car has limited fuel (gas units), each move costs 1 fuel
Follow-up 2: Some cells are gas stations ('g') that refill fuel to full
"""

from collections import deque

# Basic - Time:O(mn), Space:O(mn)
def shortest_path(grid: list[list[str]]) -> int:
    m, n = len(grid), len(grid[0])
    
    start = end = None
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 'c':
                start = (i, j)
            elif grid[i][j] == 'o':
                end = (i, j)
    if not start or not end:
        return -1
    
    que = deque([(start[0], start[1])])
    vis = [[False] * n for  _ in range(m)]
    vis[start[0]][start[1]] = True
    steps = 0

    while que:
        for _ in range(len(que)):
            r, c = que.popleft()
            if (r, c) == end:
                return steps
            
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and not vis[nr][nc]:
                    vis[nr][nc] = True
                    que.append((nr, nc))
        steps += 1
    
    return -1

# follow-up1: with limited fuel
# Time:O(mnF), Space:O(mnF)
def shortest_path_fuel(grid: list[list[str]], fuel: int) -> int:
    m, n = len(grid), len(grid[0])
    
    start = end = None
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 'c':
                start = (i, j)
            elif grid[i][j] == 'o':
                end = (i, j)
    if not start or not end:
        return -1
    
    que = deque([(start[0], start[1], fuel)])
    vis = set([(start[0], start[1], fuel)])
    steps = 0

    while que:
        for _ in range(len(que)):
            r, c, f = que.popleft()
            if (r, c) == end:
                return steps
            
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = r + dr, c + dc
                nf = f - 1
                if 0 <= nr < m and 0 <= nc < n and nf >= 0:
                    if (nr, nc, nf) not in vis:
                        vis.add((nr, nc, nf))
                        que.append((nr, nc, nf))
        steps += 1
    
    return -1

# follow-up2: with gas station
# Time:O(mnF), Space:O(mnF)
def shortest_path_gas(grid: list[list[str]], fuel: int) -> int:
    m, n = len(grid), len(grid[0])
    
    start = end = None
    for i in range(m):
        for j in range(n):
            if grid[i][j] == 'c':
                start = (i, j)
            elif grid[i][j] == 'o':
                end = (i, j)
    if not start or not end:
        return -1
    
    que = deque([(start[0], start[1], fuel)])
    vis = set([(start[0], start[1], fuel)])
    steps = 0

    while que:
        for _ in range(len(que)):
            r, c, f = que.popleft()
            if (r, c) == end:
                return steps
            
            for dr, dc in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n:
                    nf = f - 1
                    if nf < 0:
                        continue

                    if grid[nr][nc] == 'g':
                        nf = fuel
                    
                    if (nr, nc, nf) not in vis:
                        vis.add((nr, nc, nf))
                        que.append((nr, nc, nf))
        steps += 1
    
    return -1

print("Original Problem Test:")
grid1 = [
    ["c", "x", "x"],
    ["x", "x", "x"],
    ["x", "x", "o"]
]
print(f"Grid 1 shortest path: {shortest_path(grid1)}")  # expect output: 4

print("\nFollow-up 1 Test (fuel=5):")
print(f"With fuel: {shortest_path_fuel(grid1, 5)}")  # expect output: 4

print("\nFollow-up 1 Test (fuel=2):")
print(f"With fuel: {shortest_path_fuel(grid1, 2)}")  # expect output: -1

print("\nFollow-up 2 Test (gas station):")
grid2 = [
    ["c", "x", "x"],
    ["x", "g", "x"],
    ["x", "x", "o"]
]
print(f"With gas stations, fuel=2: {shortest_path_gas(grid2, 2)}")  # expect output: 4
