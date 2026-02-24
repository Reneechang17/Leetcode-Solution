# Time:O(k*d), Space:O(1)

from typing import List

class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        s = str(n)
        k = len(s)
        d = len(digits)

        res = sum(d ** i for i in range(1, k))

        for i, c in enumerate(s):
            smaller = sum(1 for x in digits if x < c)
            res += smaller * (d ** (k - i - 1))

            if c not in digits:
                break
        else:
            res += 1
        
        return res
    