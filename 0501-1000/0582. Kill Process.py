# Time:O(n), Space:O(n)

from collections import defaultdict, deque
from typing import List

class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        # parent -> [children]
        graph = defaultdict(list)
        for i in range(len(pid)):
            graph[ppid[i]].append(pid[i])
        
        res = []
        que = deque([kill])

        while que:
            cur = que.popleft()
            res.append(cur)
            que.extend(graph[cur])
        
        return res
