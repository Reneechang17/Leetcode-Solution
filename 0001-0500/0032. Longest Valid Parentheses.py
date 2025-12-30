
# Stack
# Time:O(n), Space:O(n)
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        stack = [-1]
        max_len = 0

        for i, c in enumerate(s):
            if c == '(':
                stack.append(i)
            else:
                stack.pop()

                if not stack:
                    stack.append(i)
                else:
                    max_len = max(max_len, i - stack[-1])
        
        return max_len

# Two-way scanning
# Time:O(n), Space:O(1) 
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        max_len = 0
        left = right = 0

        for c in s:
            if c == '(':
                left += 1
            else:
                right += 1
            
            if left == right:
                max_len = max(max_len, 2 * right)
            elif right > left:
                left = right = 0
        
        left = right = 0
        for c in reversed(s):
            if c == '(':
                left += 1
            else:
                right += 1
            
            if left == right:
                max_len = max(max_len, 2 * left)
            elif left > right:
                left = right = 0
        
        return max_len
    