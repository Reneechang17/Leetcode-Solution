# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/

class Solution:
    def robotWithString(self, s: str) -> str:
        n = len(s)

        min_suffix = [''] * n
        min_suffix[-1] = s[-1]
        for i in range(n - 2, -1, -1):
            min_suffix[i] = min(s[i], min_suffix[i + 1])
        
        stack = []
        res = []

        for i in range(n):
            stack.append(s[i])
            
            while stack:
                if i + 1 < n:
                    if stack[-1] <= min_suffix[i + 1]:
                        res.append(stack.pop())
                    else:
                        break
                else:
                    res.append(stack.pop())

        return ''.join(res)
    