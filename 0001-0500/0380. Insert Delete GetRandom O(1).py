# Time:O(1), Space:O(n)

import random

class RandomizedSet:

    def __init__(self):
        self.arr = []
        self.map = {} # val -> idx in arr

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False
        
        self.map[val] = len(self.arr)
        self.arr.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False
        
        index = self.map[val]
        last_val = self.arr[-1]

        # move the last element to id (cover val)
        # for O(1), instead of moving n's element
        self.arr[index] = last_val
        self.map[last_val] = index

        # del the last element
        self.arr.pop()
        del self.map[val]

        return True

    def getRandom(self) -> int:
        return random.choice(self.arr)
