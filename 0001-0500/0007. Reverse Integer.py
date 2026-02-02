# Time:O(logn), Space:O(1)

class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x = abs(x)

        INT_MAX = 2**31 - 1
        res = 0

        while x > 0:
            d = x % 10
            x //= 10

            if res > INT_MAX // 10 or (res == INT_MAX // 10 and d > 7):
                return 0
            
            res = res * 10 + d
        
        return sign * res
    