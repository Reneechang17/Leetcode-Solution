# Time:O(1), Space:O(k)

from collections import deque
from typing import List

class ZigzagIterator:
    def __init__(self, v1: List[int], v2: List[int]):
        self.que = deque()

        if v1:
            self.que.append((v1, 0))
        if v2:
            self.que.append((v2, 0))

    def next(self) -> int:
        vec, idx = self.que.popleft()
        val = vec[idx]

        if idx + 1 < len(vec):
            self.que.append((vec, idx + 1))

        return val

    def hasNext(self) -> bool:
        return len(self.que) > 0
