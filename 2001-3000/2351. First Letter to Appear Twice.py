# Time:O(n), Space:O(1)

class Solution:
    def repeatedCharacter(self, s: str) -> str:
        vis = set()
        
        for c in s:
            if c in vis:
                return c
            vis.add(c)
        
        return ""
    