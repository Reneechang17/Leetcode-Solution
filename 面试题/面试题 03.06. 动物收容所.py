# Time:O(1), Space:O(n)

from typing import List

class AnimalShelf:

    def __init__(self):
        self.cats = []
        self.dogs = []
        self.ts = 0

    def enqueue(self, animal: List[int]) -> None:
        animal.append(self.ts)
        self.ts += 1
        if animal[1] == 0:
            self.cats.append(animal)
        else:
            self.dogs.append(animal)

    def dequeueAny(self) -> List[int]:
        if not self.cats and not self.dogs:
            return [-1, -1]
        if not self.cats:
            return self.dogs.pop(0)[:2]
        if not self.dogs:
            return self.cats.pop(0)[:2]
        if self.cats[0][2] < self.dogs[0][2]:
            return self.cats.pop(0)[:2]
        else:
            return self.dogs.pop(0)[:2]

    def dequeueDog(self) -> List[int]:
        if not self.dogs:
            return [-1, -1]
        return self.dogs.pop(0)[:2]

    def dequeueCat(self) -> List[int]:
        if not self.cats:
            return [-1, -1]
        return self.cats.pop(0)[:2]
    