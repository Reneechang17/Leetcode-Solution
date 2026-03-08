# Time:O(1), Space:O(3*stackSize)

class TripleInOne:

    def __init__(self, stackSize: int):
        self.stackSize = stackSize
        self.arr = [0] * (3 * stackSize)
        self.pointers = [0, 0, 0] 

    def push(self, stackNum: int, value: int) -> None:
        if self.pointers[stackNum] < self.stackSize:
            idx = stackNum * self.stackSize + self.pointers[stackNum]
            self.arr[idx] = value
            self.pointers[stackNum] += 1

    def pop(self, stackNum: int) -> int:
        if self.isEmpty(stackNum):
            return -1
        self.pointers[stackNum] -= 1
        idx = stackNum * self.stackSize + self.pointers[stackNum]
        return self.arr[idx]

    def peek(self, stackNum: int) -> int:
        if self.isEmpty(stackNum):
            return -1
        idx = stackNum * self.stackSize + self.pointers[stackNum] - 1
        return self.arr[idx]

    def isEmpty(self, stackNum: int) -> bool:
        return self.pointers[stackNum] == 0
    