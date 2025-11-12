# Medium
# Union Find
# Time:O(E log E), Space:O(n)
# https://leetcode.cn/problems/connecting-cities-with-minimum-cost/

from typing import *

class Solution:
    def minimumCost(self, n: int, connections: List[List[int]]) -> int:
        # Union Find
        parent = list(range(n + 1))

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            px, py = find(x), find(y)
            if px == py:
                return False
            parent[px] = py
            return True
        
        connections.sort(key=lambda x:x[2])
        
        total = 0
        edges = 0

        for u, v, cost in connections:
            if union(u, v):
                total += cost
                edges += 1

                if edges == n - 1:
                    return total
        
        return -1
    