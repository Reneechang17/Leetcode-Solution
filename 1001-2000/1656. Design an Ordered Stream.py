# Time:O(1), Space:O(n)

from typing import *

class OrderedStream:

    def __init__(self, n: int):
        self.arr = [""] * (n + 1)
        self.ptr = 1

    def insert(self, idKey: int, value: str) -> List[str]:
        self.arr[idKey] = value

        if idKey != self.ptr:
            return []

        res = []
        while self.ptr < len(self.arr) and self.arr[self.ptr] != "":
            res.append(self.arr[self.ptr])
            self.ptr += 1
        
        return res
    