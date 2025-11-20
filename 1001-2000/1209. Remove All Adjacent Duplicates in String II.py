# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = [] # (char, count)

        for c in s:
            if stack and stack[-1][0] == c:
                stack[-1] = (c, stack[-1][1] + 1)

                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append((c, 1))
        
        res = []
        for c, cnt in stack:
            res.append(c * cnt) # remaining
        
        return ''.join(res)
    