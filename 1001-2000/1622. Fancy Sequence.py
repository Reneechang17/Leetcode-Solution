# Time:O(logMOD), Space:O(1)

class Fancy:
    MOD = 10**9 + 7

    def __init__(self):
        self.mul = 1
        self.add = 0
        self.arr = []

    def _mod_pow(self, x, n):
        res = 1
        base = x
        while n > 0:
            if n % 2 == 1:  
                res = (res * base) % self.MOD
            base = (base * base) % self.MOD
            n //= 2 
        return res

    def append(self, val: int) -> None:
        # 基值 = (val - add) * inv(mul) % MOD
        # 先算 (val - add) 并调整到正数
        val_minus_add = (val - self.add) % self.MOD
        # 求 mul 的逆元（费马小定理）
        inv_mul = self._mod_pow(self.mul, self.MOD - 2)
        base_val = (val_minus_add * inv_mul) % self.MOD
        self.arr.append(base_val)

    def addAll(self, inc: int) -> None:
        self.add = (self.add + inc) % self.MOD

    def multAll(self, m: int) -> None:
        self.mul = (self.mul * m) % self.MOD
        self.add = (self.add * m) % self.MOD

    def getIndex(self, idx: int) -> int:
        if idx < 0 or idx >= len(self.arr):
            return -1
        return (self.arr[idx] * self.mul + self.add) % self.MOD
    