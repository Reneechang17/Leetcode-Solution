from typing import *

# Simulate the operations, check if top is the one point to popped arr.

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = []
        j = 0 # point to popped

        for x in pushed:
            stack.append(x)

            while stack and stack[-1] == popped[j]:
                stack.pop()
                j += 1
        
        return len(stack) == 0
    