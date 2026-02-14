# Time:O(n²), Space:O(1)

class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        n = len(s)
        ans = 0

        for i in range(n):
            cnt = 0
            for j in range(i, n):
                if j > i and s[j] == s[j - 1]:
                    cnt += 1
                if cnt > 1:
                    break
                ans = max(ans, j - i + 1)
        
        return ans
    