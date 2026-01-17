# Time:O(V+E), Space:O(V+E)

from typing import *
from collections import defaultdict, deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        in_degree = [0] * numCourses

        for course, prereq in prerequisites:
            graph[prereq].append(course)
            in_degree[course] += 1
        
        que = deque([i for i in range(numCourses) if in_degree[i] == 0])
        count = 0

        while que:
            node = que.popleft()
            count += 1

            # process neighbor
            for n in graph[node]:
                in_degree[n] -= 1
                if in_degree[n] == 0:
                    que.append(n)
        
        return count == numCourses
