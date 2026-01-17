# Time:O(n*d), Space:O(1)

from typing import List

class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        def is_self_dividing(num):
            tmp = num
            while tmp:
                digit = tmp % 10
                if digit == 0 or num % digit != 0:
                    return False
                tmp //= 10

            return True

        res = []
        for num in range(left, right + 1):
            if is_self_dividing(num):
                res.append(num)

        return res
