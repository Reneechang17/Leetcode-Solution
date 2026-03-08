# Time - push:O(n), others:O(1)
# Space:O(n)

class SortedStack:

    def __init__(self):
        self.stack = []
        self.tmp_stack = []

    def push(self, val: int) -> None:
        while self.stack and self.stack[-1] < val:
            self.tmp_stack.append(self.stack.pop())
        
        self.stack.append(val)

        while self.tmp_stack:
            self.stack.append(self.tmp_stack.pop())

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()

    def peek(self) -> int:
        if not self.stack:
            return -1
        return self.stack[-1]

    def isEmpty(self) -> bool:
        return not self.stack
    