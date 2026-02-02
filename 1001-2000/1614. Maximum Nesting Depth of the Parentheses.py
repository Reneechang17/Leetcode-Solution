# Time:O(n), Space:O(1)

class Solution:
    def maxDepth(self, s: str) -> int:
        cur_depth, max_depth = 0, 0
        
        for c in s:
            if c == "(":
                cur_depth += 1
                max_depth = max(max_depth, cur_depth)
            elif c == ")":
                cur_depth -= 1
        
        return max_depth
    