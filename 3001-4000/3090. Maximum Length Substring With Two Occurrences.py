# Time:O(n), Space:O(1)

class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        cnt = [0] * 26
        n = len(s)
        left = 0
        ans = 0

        for right in range(n):
            idx = ord(s[right]) - ord('a')
            cnt[idx] += 1

            # when a char appears more than 2
            # shrink left 
            while cnt[idx] > 2:
                left_idx = ord(s[left]) - ord('a')
                cnt[left_idx] -= 1
                left += 1
            
            ans = max(ans, right - left + 1)
        
        return ans
    