# Medium
# Greedy, Binary Search
# Time:O(n log(sum+k)), Space:O(n)
# https://leetcode.cn/problems/lexicographically-minimum-string-after-removing-stars/

import heapq

class Solution:
    def clearStars(self, s: str) -> str:
        n = len(s)
        flag = [False] * n
        heap = [] # (char, -index)

        for i, char in enumerate(s):
            if char == '*':
                flag[i] = True
                if heap:
                    _, idx = heapq.heappop(heap)
                    flag[-idx] = True
            else:
                heapq.heappush(heap, (char, -i)) # negative -> prior smal

        return ''.join(s[i] for i in range(n) if not flag[i])
