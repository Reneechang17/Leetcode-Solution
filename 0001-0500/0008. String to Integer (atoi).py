# Time:O(n), Space:O(1)

class Solution:
    def myAtoi(self, s: str) -> int:
        i = 0
        n = len(s)

        while i < n and s[i] == " ":
            i += 1

        if i == n:
            return 0

        sign = 1
        if s[i] == "-":
            sign = -1
            i += 1
        elif s[i] == "+":
            i += 1

        res = 0
        while i < n and s[i].isdigit():
            digit = int(s[i])

            if res > (2**31 - 1) // 10 or (res == (2**31 - 1) // 10 and digit > 7):
                return 2**31 - 1 if sign == 1 else -(2**31)

            res = res * 10 + digit
            i += 1

        return sign * res
