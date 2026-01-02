# Time:O(logn), Space:O(logn)

class Solution:
    def findIntegers(self, n: int) -> int:
        # n -> binary
        binary = bin(n)[2:]
        k = len(binary)

        fib = [0] * (k + 1)
        fib[0] = 1
        fib[1] = 2

        for i in range(2, k + 1):
            fib[i] = fib[i - 1] + fib[i - 2]

        res = 0
        prev_bit = 0

        for i in range(k):
            if binary[i] == "1":
                res += fib[k - i - 1]

                if prev_bit == 1:
                    return res

                prev_bit = 1
            else:
                prev_bit = 0

        return res + 1
