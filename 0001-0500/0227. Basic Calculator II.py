# use stack to handle prioritize, if meets '+' or '-' -> push in
# '*' or '/' -> pop out, calculate and push back the res

class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        op = '+'

        for i, c in enumerate(s):
            if c.isdigit():
                num = num * 10 + int(c)
            
            if (c != ' ' and not c.isdigit()) or i == len(s) - 1:
                if op == '+':
                    stack.append(num)
                elif op == '-':
                    stack.append(-num)
                elif op == '*':
                    stack.append(stack.pop() * num)
                elif op == '/':
                    stack.append(int(stack.pop() / num))
                
                op = c 
                num = 0
        
        return sum(stack)      
