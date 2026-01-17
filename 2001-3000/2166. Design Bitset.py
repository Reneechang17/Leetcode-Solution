class Bitset:

    def __init__(self, size: int):
        self.size = size
        self.bits = [0] * size
        self.one_count = 0
        self.flipped = False
    
    def _get_display(self, idx: int) -> int:
        return self.bits[idx] ^ self.flipped
        
    def fix(self, idx: int) -> None:
        if self._get_display(idx) == 0:
            self.bits[idx] = 1 ^ self.flipped
            self.one_count += 1

    def unfix(self, idx: int) -> None:
        if self._get_display(idx) == 1:
            self.bits[idx] = 0 ^ self.flipped
            self.one_count -= 1

    def flip(self) -> None:
        self.flipped = not self.flipped
        self.one_count = self.size - self.one_count

    def all(self) -> bool:
        return self.one_count == self.size

    def one(self) -> bool:
        return self.one_count > 0

    def count(self) -> int:
        return self.one_count

    def toString(self) -> str:
        res = []
        for i in range(self.size):
            res.append(str(self._get_display(i)))
        return ''.join(res)
