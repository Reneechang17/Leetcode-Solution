# Time:O(n), Space:O(n)

from typing import Counter

class Solution:
    def maxRepOpt1(self, text: str) -> int:
        freq = Counter(text)
        
        segments = []
        i = 0
        n = len(text)
        while i < n:
            j = i
            while j < n and text[j] == text[i]:
                j += 1
            segments.append((text[i], j - i))
            i = j
        
        ans = 0
        m = len(segments)
        
        for i in range(m):
            c, length = segments[i]
            total = freq[c]
            ans = max(ans, length + (1 if total > length else 0))
        
        for i in range(m - 2):
            ch1, len1 = segments[i]
            ch2, len2 = segments[i+1]
            ch3, len3 = segments[i+2]
            if ch1 == ch3 and len2 == 1:  
                total = freq[ch1]
                merge_len = len1 + len3
                if total > merge_len:
                    merge_len += 1 
                ans = max(ans, merge_len)
        
        return ans
    