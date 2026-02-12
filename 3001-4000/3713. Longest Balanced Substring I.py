# Time:O(n² × 26), Space:O(26)

class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        ans = 0

        for i in range(n):
            cnt = {}
            for j in range(i, n):
                cnt[s[j]] = cnt.get(s[j], 0) + 1
                vals = list(cnt.values())
                if min(vals) == max(vals):
                    ans = max(ans, j - i + 1)
        
        return ans
    