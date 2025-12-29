# Time:O(n²), Space:O(1)

class Solution:
    def countSubstrings(self, s: str) -> int:
        count = 0
        n = len(s)

        def expand(left, right):
            nonlocal count
            while left >= 0 and right < n and s[left] == s[right]:
                count += 1
                left -= 1
                right += 1

        for i in range(n):
            expand(i, i) # odd
            expand(i, i + 1) # even
        
        return count
    