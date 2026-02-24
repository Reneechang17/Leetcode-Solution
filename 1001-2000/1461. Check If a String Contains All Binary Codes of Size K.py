# Time:O(nk), Space:O(2^k)

class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        total = 2 ** k
        seen = set()

        for i in range(len(s) - k + 1):
            seen.add(s[i:i+k])
            if len(seen) == total:
                return True
        
        return False
    