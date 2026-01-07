# TODO: Actually I CV lol~, need to TAL when I free.
# Time:O(log²n), Space:O(1)

class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend == -(2**31) and divisor == -1:
            return 2**31 - 1

        neg = (dividend < 0) != (divisor < 0)

        dividend, divisor = abs(dividend), abs(divisor)
        quo = 0

        while dividend >= divisor:
            tmp, mul = divisor, 1

            while dividend >= (tmp << 1):
                tmp <<= 1
                mul <<= 1

            dividend -= tmp
            quo += mul

        return -quo if neg else quo
