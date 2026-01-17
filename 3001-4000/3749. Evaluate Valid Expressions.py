# Time:O(n), Space:O(n)

class Solution:
    def evaluateExpression(self, expression: str) -> int:
        self.i = 0
        return self.parse(expression)

    def parse(self, s):
        if s[self.i].isdigit() or s[self.i] == "-":
            return self.parse_number(s)

        op = self.parse_op(s)
        self.i += 1  # skip '('

        a = self.parse(s)
        self.i += 1  # skip ','

        b = self.parse(s)
        self.i += 1  # skip ')'

        if op == "add":
            return a + b
        elif op == "sub":
            return a - b
        elif op == "mul":
            return a * b
        else:
            return int(a / b)

    def parse_number(self, s):
        start = self.i
        if s[self.i] == "-":
            self.i += 1
        while self.i < len(s) and s[self.i].isdigit():
            self.i += 1
        return int(s[start : self.i])

    def parse_op(self, s):
        start = self.i
        while self.i < len(s) and s[self.i] != "(":
            self.i += 1
        return s[start : self.i]
    