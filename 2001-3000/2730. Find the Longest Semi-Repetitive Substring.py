# Time:O(n), Space:O(1)

class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        n = len(s)
        left = 0
        ans = 1
        pair_cnt = 0

        for right in range(1, n):
            if s[right] == s[right - 1]:
                pair_cnt += 1
            
            while pair_cnt > 1:
                if s[left] == s[left + 1]:
                    pair_cnt -= 1
                left += 1
            
            ans = max(ans, right - left + 1)
        
        return ans
    