# Time:O(n), Space:O(n)

from collections import defaultdict, deque
from typing import List

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]

        graph = defaultdict(set)
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)

        leaves = deque([i for i in range(n) if len(graph[i]) == 1])

        remaining = n
        while remaining > 2:
            leaves_count = len(leaves)
            remaining -= leaves_count
            for i in range(leaves_count):
                leaf = leaves.popleft()
                neighbor = graph[leaf].pop()
                graph[neighbor].remove(leaf)
                if len(graph[neighbor]) == 1:
                    leaves.append(neighbor)

        return list(leaves)
    