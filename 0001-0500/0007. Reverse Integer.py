# Time:O(logn), Space:O(1)

class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x = abs(x)

        res = 0

        while x > 0:
            d = x % 10
            x //= 10

            if res > (2**31 - 1) // 10:
                return 0

            res = res * 10 + d

        res *= sign

        if res < -(2**31) or res > 2**31 - 1:
            return 0

        return res
    