# Time:O(1), Space:O(n)

import random

class RandomizedCollection:

    def __init__(self):
        self.vals = []
        self.map = {}

    def insert(self, val: int) -> bool:
        exist = val not in self.map

        if exist:
            self.map[val] = set()

        self.map[val].add(len(self.vals))
        self.vals.append(val)
        return exist

    def remove(self, val: int) -> bool:
        if val not in self.map or not self.map[val]:
            return False

        index = self.map[val].pop()
        last_val = self.vals[-1]

        self.vals[index] = last_val
        self.map[last_val].add(index)
        self.map[last_val].discard(len(self.vals) - 1)

        self.vals.pop()

        if not self.map[val]:
            del self.map[val]

        return True

    def getRandom(self) -> int:
        return random.choice(self.vals)
    