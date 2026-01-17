# Time:O(log₂₆ n), Space:O(log₂₆ n)

class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        res = []
        n = columnNumber
        while n > 0:
            n -= 1
            remainder = n % 26
            res.append(letters[remainder])
            n //= 26

        return "".join(reversed(res))
