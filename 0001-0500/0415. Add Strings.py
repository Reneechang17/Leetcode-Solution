# Time:O(n), Space:O(n)

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        res = []
        carry = 0
        i, j = len(num1) - 1, len(num2) - 1

        while i >= 0 or j >= 0 or carry:
            d1 = int(num1[i]) if i >= 0 else 0
            d2 = int(num2[j]) if j >= 0 else 0

            total = d1 + d2 + carry
            res.append(str(total % 10))
            carry = total // 10

            i -= 1
            j -= 1

        return "".join(reversed(res))
