# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/remove-k-balanced-substrings/

# similar pattern to 1209

class Solution:
    def removeSubstring(self, s: str, k: int) -> str:
        stack = [] # (char, count)

        for c in s:
            if c == '(':
                if stack and stack[-1][0] == '(':
                    stack[-1] = ('(', stack[-1][1] + 1)
                else:
                    stack.append(('(', 1))
            else:
                if stack and stack[-1][0] == ')':
                    stack[-1] = (')', stack[-1][1] + 1)
                else:
                    stack.append((')', 1))
                
                # check if it forms k-balanced
                if len(stack) >= 2 and stack[-1][0] == ')' and stack[-2][0] == '(':
                    if stack[-2][1] >= k and stack[-1][1] >= k:
                        # del k
                        stack[-2] = ('(', stack[-2][1] - k)
                        stack[-1] = (')', stack[-1][1] - k)

                        # clean up zero count
                        if stack[-1][1] == 0:
                            stack.pop()
                        if stack and stack[-1][0] == '(' and stack[-1][1] == 0:
                            stack.pop()
        res = []
        for c, cnt in stack:
            res.append(c * cnt)
        return ''.join(res)
