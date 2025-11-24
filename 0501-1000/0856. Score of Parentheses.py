# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/score-of-parentheses/

class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        stack = [0] # init the score as 0

        for c in s:
            if c == '(':
                stack.append(0)
            else:
                cur = stack.pop()
                score = max(2 * cur, 1)
                stack[-1] += score
        
        return stack[0]
    