# Medium
# Stack
# Time:O(1), Space:O(n)
# https://leetcode.cn/problems/design-a-stack-with-increment-operation/

class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = []
        self.inc = [] # lazy update to record inc and calculate when we pop
        self.max_size = maxSize

    def push(self, x: int) -> None:
        if len(self.stack) < self.max_size:
            self.stack.append(x)
            self.inc.append(0)

    def pop(self) -> int:
        if not self.stack:
            return -1
        
        idx = len(self.stack) - 1
        val = self.stack.pop() + self.inc[idx]
        increment = self.inc.pop()

        if self.inc:
            self.inc[-1] += increment

        return val

    def increment(self, k: int, val: int) -> None:
        if self.stack:
            idx = min(k, len(self.stack)) - 1
            self.inc[idx] += val
