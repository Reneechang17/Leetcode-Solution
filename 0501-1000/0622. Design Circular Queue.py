# Medium
# Design
# Time:O(mnk), Space:O(mnk)
# https://leetcode.cn/problems/design-circular-queue/

class MyCircularQueue:

    def __init__(self, k: int):
        self.capacity = k
        self.que = [0] * k # fixed size
        self.front = 0 # front pointer
        self.rear = -1 # rear pointer
        self.size = 0 # cur num of elements

    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False
        
        # latest: move the rear pointer
        # mod capacity for circular
        self.rear = (self.rear + 1) % self.capacity
        self.que[self.rear] = value
        self.size += 1
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        
        # move the front pointer
        # to del the earliest element
        self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        
        return self.que[self.front]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        
        return self.que[self.rear]

    def isEmpty(self) -> bool:
        return self.size == 0
    
    def isFull(self) -> bool:
        return self.size == self.capacity
    