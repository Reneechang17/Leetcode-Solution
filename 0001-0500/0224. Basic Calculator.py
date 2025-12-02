# Hard
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/basic-calculator/

# challenge: need to handle '()'

class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        res = 0
        num = 0
        sign = 1 # 1 -> pos, -1 -> neg

        for char in s:
            if char.isdigit():
                num = num * 10 + int(char)
            
            elif char == '+':
                res += sign * num
                num = 0
                sign = 1
            
            elif char == '-':
                res += sign * num
                num = 0
                sign = -1

            elif char == '(':
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1
            
            elif char == ')':
                res += sign * num
                num = 0
                res *= stack.pop() # sign
                res += stack.pop() # res in brace
        
        res += sign * num
        return res
