# Time:O(logn), Space:O(1)

# 1+2+3....+k=k*(k+1)/2 =>k*(k+1)/2 <=n
# k²+k-2n <= 0

class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 1, n

        while left <= right:
            mid = (left + right) // 2
            total = mid * (mid + 1) // 2
            if total == n:
                return mid
            elif total < n:
                left = mid + 1
            else:
                right = mid - 1
        
        return right
    