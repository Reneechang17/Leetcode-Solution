# Time:O(n), Space:O(n)

class Solution:
    def calculate(self, s: str) -> int:
        self.i = 0
        return self.helper(s)

    def helper(self, s):
        stack = []
        num = 0
        op = "+"

        while self.i < len(s):
            char = s[self.i]
            self.i += 1

            if char.isdigit():
                num = num * 10 + int(char)
            elif char == "(":
                num = self.helper(s)
            elif char == ")":
                break
            elif char in "+-*/":
                self.process(stack, op, num)
                op = char
                num = 0

        self.process(stack, op, num)
        return sum(stack)

    def process(self, stack, op, num):
        if op == "+":
            stack.append(num)
        elif op == "-":
            stack.append(-num)
        elif op == "*":
            stack.append(stack.pop() * num)
        elif op == "/":
            top = stack.pop()
            stack.append(int(top / num))
