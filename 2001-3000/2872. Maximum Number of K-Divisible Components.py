# Hard
# DFS, Greedy
# Time:, Space:
# https://leetcode.cn/problems/maximum-number-of-k-divisible-components/

from typing import *

class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        from collections import defaultdict

        graph = defaultdict(list)
        for u, v in graph:
            graph[u].append(v)
            graph[v].append(u)
        
        res = [0]

        def dfs(node, parent):
            sub_sum = values[node]

            for n in graph[node]:
                if n != parent:
                    child_sum = dfs(n, node)
                    sub_sum += child_sum
                
            if sub_sum % k == 0:
                res[0] += 1
            
            return sub_sum
        
        dfs(0, -1)
        return res[0]
    