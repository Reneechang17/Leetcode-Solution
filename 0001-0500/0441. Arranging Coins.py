# Time:O(logn), Space:O(1)

# use binary search to find the most K that k*(k+1)/2<=n
class Solution:
    def arrangeCoins(self, n: int) -> int:
        left, right = 1, n

        while left <= right:
            mid = (left + right) // 2

            needed = mid * (mid + 1) // 2
            if needed == n:
                return mid
            elif needed < n:
                left = mid + 1
            else:
                right = mid - 1
                
        return right
    