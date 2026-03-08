# Time:O(1), Space:O(n)

class StackOfPlates:

    def __init__(self, cap: int):
        self.cap = cap
        self.stack = []

    def push(self, val: int) -> None:
        if self.cap <= 0:
            return 
        if not self.stack or len(self.stack[-1]) == self.cap:
            self.stack.append([val])
        else:
            self.stack[-1].append(val)

    def pop(self) -> int:
        if not self.stack:
            return -1
        val = self.stack[-1].pop()
        if not self.stack[-1]:
            self.stack.pop()
        return val

    def popAt(self, index: int) -> int:
        if index < 0 or index >= len(self.stack):
            return -1
        val = self.stack[index].pop()
        if not self.stack[index]:
            self.stack.pop(index)
        return val
    