# Time:O(logn), Space:O(1)

class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        prod = 1
        total = 0

        while n > 0:
            d = n % 10
            prod *= d
            total += d
            n //= 10
        
        return prod - total
        