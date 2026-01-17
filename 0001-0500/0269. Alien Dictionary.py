# Time:O(C), Space:O(1)

from collections import defaultdict, deque
from typing import List

class Solution:
    def alienOrder(self, words: List[str]) -> str:
        graph = defaultdict(set)
        indegree = {c:0 for word in words for c in word}

        for i in range(len(words) - 1):
            w1, w2 = words[i], words[i+1]
            min_len = min(len(w1), len(w2))
            if len(w1) > len(w2) and w1[:min_len] == w2[:min_len]:
                return ""
            
            for j in range(min_len):
                if w1[j] != w2[j]:
                    if w2[j] not in graph[w1[j]]:
                        graph[w1[j]].add(w2[j])
                    break
            
        for u in graph:
            for v in graph[u]:
                indegree[v] = indegree.get(v, 0) + 1
        
        que = deque([c for c in indegree if indegree[c] == 0])
        order = []

        while que:
            u = que.popleft()
            order.append(u)
            for v in graph[u]:
                indegree[v] -= 1
                if indegree[v] == 0:
                    que.append(v)
        if len(order) != len(indegree):
            return ""
        
        return ''.join(order)
    