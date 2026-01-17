# Time:O(n), Space:O(1)

class Solution:
    def makePalindrome(self, s: str) -> bool:
        left, right = 0, len(s) - 1
        mismatch = 0

        while left < right:
            if s[left] != s[right]:
                mismatch += 1
                if mismatch > 2:
                    return False
            left += 1
            right -= 1

        return True
