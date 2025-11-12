# Medium
# Design
# https://leetcode.cn/problems/rle-iterator/

from typing import *

class RLEIterator:

    def __init__(self, encoding: List[int]):
        self.enc = encoding
        self.i = 0 # current [cnt, num] pair
        self.remaining = encoding[0] if encoding else 0 # remaining for current group

    def next(self, n: int) -> int:
        while self.i < len(self.enc):
            if self.remaining >= n:
                self.remaining -= n
                return self.enc[self.i + 1]
            
            else:
                n -= self.remaining
                self.i += 2 # jump to next number
                if self.i < len(self.enc):
                    self.remaining = self.enc[self.i]
        
        return -1
    