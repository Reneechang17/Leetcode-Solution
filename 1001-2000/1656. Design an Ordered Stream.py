# Time:O(n), Space:O(n)

from typing import *

class OrderedStream:

    def __init__(self, n: int):
        self.stream = [None] * (n + 1) 
        self.ptr = 1 # point to next exp ID
        
    def insert(self, idKey: int, value: str) -> List[str]:
        self.stream[idKey] = value
        res = []
        
        # check if cur ptr has value
        if self.stream[self.ptr] is not None:
            # collect consecutive values
            while self.ptr < len(self.stream) and self.stream[self.ptr] is not None:
                res.append(self.stream[self.ptr])
                self.ptr += 1
        return res
    