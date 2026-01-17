# Time:O(V+E), Space:O(V+E)

from collections import deque
from typing import List

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses

        for a, b in prerequisites:
            graph[b].append(a)
            indegree[a] += 1

        que = deque([i for i in range(numCourses) if indegree[i] == 0])
        res = []

        while que:
            node = que.popleft()
            res.append(node)
            for neighbor in graph[node]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    que.append(neighbor)

        return res if len(res) == numCourses else []
    