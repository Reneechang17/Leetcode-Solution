# Time:O(logn), Space:O(logn)

class Solution:
    def nextGreaterElement(self, n: int) -> int:
        digits = list(str(n))
        length = len(digits)

        # find the first decreasing pos from the end
        i = length - 2
        while i >= 0 and digits[i] >= digits[i + 1]:
            i -= 1

        if i == -1:
            return -1

        # find the first digit larger than digits[i] from the end
        j = length - 1
        while j > i and digits[j] <= digits[i]:
            j -= 1

        digits[i], digits[j] = digits[j], digits[i]

        digits[i + 1 :] = digits[i + 1 :][::-1]

        res = int("".join(digits))

        return res if res <= 2**31 - 1 else -1
