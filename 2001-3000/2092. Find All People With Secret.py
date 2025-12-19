# Time:O(mlogm+m*n), Space:O(n+m)

from typing import List
from collections import defaultdict, deque

class Solution:
    def findAllPeople(self, n: int, meetings: List[List[int]], firstPerson: int) -> List[int]:
        knows_secret = set([0, firstPerson])

        meetings.sort(key=lambda x:x[2])

        i = 0
        while i < len(meetings):
            cur_time = meetings[i][2]
            
            graph = defaultdict(list)
            people = set()

            j = i
            # find all meetings happen on cur_time
            while j < len(meetings) and meetings[j][2] == cur_time:
                x, y, _ = meetings[j]
                graph[x].append(y)
                graph[y].append(x)
                people.add(x)
                people.add(y)
                j += 1

            que = deque()
            for p in people:
                if p in knows_secret:
                    que.append(p) 
            vis = set(que)

            while que:
                person = que.popleft()
                for n in graph[person]:
                    if n not in vis:
                        vis.add(n)
                        knows_secret.add(n)
                        que.append(n)
            i = j
        
        return list(knows_secret)
    