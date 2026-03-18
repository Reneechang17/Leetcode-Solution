# Time:O(n), Space:O(1)

class Solution:
    def balancedString(self, s: str) -> int:
        n = len(s)
        target = n // 4
        cnt = {'Q': 0, 'W': 0, 'E': 0, 'R': 0}
        for c in s:
            cnt[c] += 1

        # check if already balanced
        if all(v == target for v in cnt.values()):
            return 0
        
        left = 0
        min_len = n
        window = {'Q': 0, 'W': 0, 'E': 0, 'R': 0}
        
        for right in range(n):
            window[s[right]] += 1
            
            while (cnt['Q'] - window['Q'] <= target and
                   cnt['W'] - window['W'] <= target and
                   cnt['E'] - window['E'] <= target and
                   cnt['R'] - window['R'] <= target):
                min_len = min(min_len, right - left + 1)
                window[s[left]] -= 1
                left += 1
        
        return min_len
    