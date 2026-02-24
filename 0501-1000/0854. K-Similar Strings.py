# Time:O(n!), Space:O(n)

from collections import deque

class Solution:
    def kSimilarity(self, s1: str, s2: str) -> int:
        if s1 == s2:
            return 0

        n = len(s1)
        que = deque([(s1, 0)])
        vis = set([s1])

        while que:
            cur, steps = que.popleft()

            i = 0
            while i < n and cur[i] == s2[i]:
                i += 1
            
            # find the pos can match with s2[i]
            for j in range(i + 1, n):
                if cur[j] == s2[i] and cur[j] != s2[j]:
                    next_str = list(cur)
                    next_str[i], next_str[j] = next_str[j], next_str[i]
                    next_str = ''.join(next_str)

                    if next_str == s2:
                        return steps + 1

                    if next_str not in vis:
                        vis.add(next_str)
                        que.append((next_str, steps + 1))
        
        return -1
    