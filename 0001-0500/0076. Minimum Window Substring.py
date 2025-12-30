# Time:O(n),Space:O(k)

from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        
        need = Counter(t)

        need_count = len(need)
        
        left = 0
        min_len = float('inf')
        min_start = 0

        formed = 0

        window_count = {}

        for right in range(len(s)):
            char = s[right]
            
            window_count[char] = window_count.get(char, 0) + 1

            if char in need and window_count[char] == need[char]:
                formed += 1

            while formed == need_count and left <= right:
                window_len = right - left + 1
                if window_len < min_len:
                    min_len = window_len
                    min_start = left
                
                left_char = s[left]
                window_count[left_char] -= 1

                if left_char in need and window_count[left_char] < need[left_char]:
                    formed -= 1
                left += 1
        
        if min_len == float('inf'):
            return ""
        
        return s[min_start:min_start + min_len]
        