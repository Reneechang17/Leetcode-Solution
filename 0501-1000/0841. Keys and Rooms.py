# Time:O(n+m) m=key's number, Space:O(n)

from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n = len(rooms)
        vis = [False] * n

        def dfs(room):
            vis[room] = True
            for key in rooms[room]:
                if not vis[key]:
                    dfs(key)

        dfs(0)
        return all(vis)
    