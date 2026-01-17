# Time:O(V+E), Space:O(V+E)

from collections import defaultdict, deque
from typing import List

class Solution:
    def sequenceReconstruction(self, nums: List[int], sequences: List[List[int]]) -> bool:
        n = len(nums)
        graph = defaultdict(set)
        indegree = [0] * (n + 1)

        for seq in sequences:
            for i in range(len(seq) - 1):
                u, v = seq[i], seq[i + 1]
                if v not in graph[u]:
                    graph[u].add(v)
                    indegree[v] += 1
        
        que = deque([i for i in range(1, n + 1) if indegree[i] == 0])
        order = []

        while que:
            if len(que) > 1:
                return False
            u = que.popleft()
            order.append(u)
            for v in graph[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    que.append(v)
        
        return order == nums
    