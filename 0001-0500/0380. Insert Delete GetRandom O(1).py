# Time:O(1), Space:O(n)

import random

class RandomizedSet:

    def __init__(self):
        self.vals = []
        self.map = {}

    def insert(self, val: int) -> bool:
        if val in self.map:
            return False

        self.map[val] = len(self.vals)
        self.vals.append(val)
        return True

    def remove(self, val: int) -> bool:
        if val not in self.map:
            return False

        index = self.map[val]
        last_val = self.vals[-1]

        self.vals[index] = last_val
        self.map[last_val] = index

        self.vals.pop()
        del self.map[val]
        return True

    def getRandom(self) -> int:
        return random.choice(self.vals)
