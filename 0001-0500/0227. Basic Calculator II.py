# Time:O(n), Space:O(n)

class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        op = "+"

        for i, char in enumerate(s):
            if char.isdigit():
                num = num * 10 + int(char)

            if (char != " " and not char.isdigit()) or i == len(s) - 1:
                if op == "+":
                    stack.append(num)
                elif op == "-":
                    stack.append(-num)
                elif op == "*":
                    stack.append(stack.pop() * num)
                elif op == "/":
                    top = stack.pop()
                    stack.append(int(top / num))
                op = char
                num = 0

        return sum(stack)   
