# Time:O(2^n*n), Space:O(n)

# graph = [[1,2],[3],[3],[]]
# 0→1, 0→2, 1→3, 2→3

from typing import List

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        target = len(graph) - 1
        res = []

        def dfs(node, path):
            if node == target:
                res.append(path[:])
                return
            
            for neighbor in graph[node]:
                path.append(neighbor)
                dfs(neighbor, path)
                path.pop()
        
        dfs(0, [0])
        return res
    