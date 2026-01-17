# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def checkContradictions(
        self, equations: List[List[str]], values: List[float]
    ) -> bool:
        graph = {}
        for i in range(len(equations)):
            a, b = equations[i]
            value = values[i]

            if a not in graph:
                graph[a] = []
            if b not in graph:
                graph[b] = []

            graph[a].append((b, value))
            graph[b].append((a, 1.0 / value))

        vis = {}

        def dfs(node, value):
            if node in vis:
                exp = vis[node]
                relative = abs(exp - value) / max(abs(exp), abs(value), 1e-9)
                return relative < 1e-9

            vis[node] = value

            for neighbor, edge in graph[node]:
                if not dfs(neighbor, value * edge):
                    return False

            return True

        for node in graph:
            if node not in vis:
                if not dfs(node, 1.0):
                    return True

        return False
