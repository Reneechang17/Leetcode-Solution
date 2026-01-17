# Medium
# Simulation
# Time:O(n*d), Space:O(1) -> fixed size
# https://leetcode.cn/problems/next-greater-numerically-balanced-number/

class Solution:
    def nextBeautifulNumber(self, n: int) -> int:
        def is_balance(num):
            count = [0] * 10
            tmp = num
            while tmp:
                count[tmp % 10] += 1
                tmp //= 10

            for d in range(10):
                if count[d] > 0 and count[d] != d:
                    return False
            return True

        num = n + 1
        while True:
            if is_balance(num):
                return num
            num += 1
