# Time:O(q*n), Space:O(n)

from typing import List

class Solution:
    def calcEquation(
        self, equations: List[List[str]], values: List[float], queries: List[List[str]]
    ) -> List[float]:
        graph = {}
        for i in range(len(equations)):
            a, b = equations[i]
            value = values[i]

            if a not in graph:
                graph[a] = {}
            if b not in graph:
                graph[b] = {}
            graph[a][b] = value
            graph[b][a] = 1.0 / value

        def dfs(start, end, vis):
            if start not in graph or end not in graph:
                return -1.0
            if start == end:
                return 1.0

            vis.add(start)

            for neighbor, value in graph[start].items():
                if neighbor not in vis:
                    res = dfs(neighbor, end, vis)
                    if res != -1.0:
                        return value * res

            return -1.0

        res = []
        for query in queries:
            res.append(dfs(query[0], query[1], set()))

        return res
