# Easy
# Math, Greedy
# Time:O(n), Space:O(1)
# https://leetcode.cn/problems/check-if-string-is-decomposable-into-value-equal-substrings/

class Solution:
    def isDecomposable(self, s: str) -> bool:
        i = 0
        has_two = False
        
        while i < len(s):
            j = i 
            while j < len(s) and s[j] == s[i]:
                j += 1
            
            length = j - i

            if length % 3 == 1:
                return False
            elif length % 3 == 2:
                if has_two:
                    return False
                has_two = True
            
            i = j
        
        return has_two
