# Hard
# Stack, Heap
# Time:O(1), Space:O(n)
# https://leetcode.cn/problems/dinner-plate-stacks/

import heapq

class DinnerPlates:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.stacks = [] # store all stacks
        self.available = [] # min heap, store available heap's index

    def push(self, val: int) -> None:
        # clean full stack(index)
        while self.available:
            idx = self.available[0]
            if idx >= len(self.stacks) or len(self.stacks[idx]) >= self.cap:
                heapq.heappop(self.available)
            else:
                break

        # if no available stack, create one
        if not self.available:
            self.stacks.append([])
            heapq.heappush(self.available, len(self.stacks) - 1)

        idx = self.available[0]
        self.stacks[idx].append(val)

    def pop(self) -> int:
        while self.stacks and not self.stacks[-1]:
            self.stacks.pop()
        
        if not self.stacks:
            return -1
        
        val = self.stacks[-1].pop()

        idx = len(self.stacks) - 1
        if len(self.stacks[-1]) < self.cap:
            heapq.heappush(self.available, idx)
        
        return val

    def popAtStack(self, index: int) -> int:
        if index >= len(self.stacks) or not self.stacks[index]:
            return -1
        
        val = self.stacks[index].pop()

        heapq.heappush(self.available, index)

        return val
        