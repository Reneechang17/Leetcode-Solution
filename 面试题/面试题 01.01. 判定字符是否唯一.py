# Time:O(n), Space:O(n)
# O(1)优化可以用位运算但是我懒得搞

class Solution:
    def isUnique(self, astr: str) -> bool:
        vis = set()
        for c in astr:
            if c in vis:
                return False
            vis.add(c)
        return True
    