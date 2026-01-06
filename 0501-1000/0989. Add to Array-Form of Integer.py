# Time:O(max(n, log k)), Space:O(max(n, log k))

from typing import List

class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        res = []
        carry = 0
        i = len(num) - 1

        while i >= 0 or k > 0 or carry:
            d = num[i] if i >= 0 else 0
            k_digit = k % 10

            total = d + k_digit + carry
            res.append(total % 10)
            carry = total // 10

            i -= 1
            k //= 10

        return res[::-1]
    