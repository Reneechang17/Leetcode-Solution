# Time:O(n), Space:O(n)

class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        n = len(number)
        last = -1

        for i in range(n):
            if number[i] == digit:
                last = i
                if i + 1 < n and number[i + 1] > digit:
                    return number[:i] + number[i + 1 :]

        return number[:last] + number[last + 1 :]
