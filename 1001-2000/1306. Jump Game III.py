# Time:O(n), Space:O(n)

from collections import deque
from typing import List

# DFS
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        n = len(arr)
        vis = [False] * n

        def dfs(i):
            if i < 0 or i >= n or vis[i]:
                return False

            if arr[i] == 0:
                return True

            vis[i] = True

            return dfs(i - arr[i]) or dfs(i + arr[i])

        return dfs(start)

# BFS
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        n = len(arr)
        vis = [False] * n
        que = deque([start])
        vis[start] = True

        while que:
            i = que.popleft()

            if arr[i] == 0:
                return True

            left = i - arr[i]
            if 0 <= left < n and not vis[left]:
                vis[left] = True
                que.append(left)

            right = i + arr[i]
            if 0 <= right < n and not vis[right]:
                vis[right] = True
                que.append(right)

        return False
    