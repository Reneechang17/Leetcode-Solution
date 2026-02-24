# Time:O(n²), Space:O(n)

class Solution:
    def makeLargestSpecial(self, s: str) -> str:
        if not s:
            return ""
        
        count = 0
        i = 0
        subs = []
        
        for j, ch in enumerate(s):
            count += 1 if ch == '1' else -1
            if count == 0:
                subs.append('1' + self.makeLargestSpecial(s[i+1:j]) + '0')
                i = j + 1
        
        subs.sort(reverse=True)
        return ''.join(subs)
    