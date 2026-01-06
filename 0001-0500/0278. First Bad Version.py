# Time:O(logn), Space:O(1)

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left, right = 1, n

        while left < right:
            mid = left + (right - left) // 2

            if isBadVersion(mid): # type: ignore
                right = mid
            else:
                left = mid + 1

        return left
    