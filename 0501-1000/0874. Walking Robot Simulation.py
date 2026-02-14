# Time:O(n+m), Space:O(k)

from typing import List

class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        d = 0 # init to north
        x = y = 0

        obs_set = set(map(tuple, obstacles))

        ans = 0
        
        for cmd in commands:
            if cmd == -2:
                d = (d - 1) % 4
            elif cmd == -1:
                d = (d + 1) % 4
            else:
                dx, dy = dirs[d]
                for _ in range(cmd):
                    nx, ny = x + dx, y + dy
                    if(nx, ny) in obs_set:
                        break
                    x, y = nx, ny
                    ans = max(ans, x * x + y * y)
        
        return ans
    