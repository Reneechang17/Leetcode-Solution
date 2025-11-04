# Easy
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/

class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []

        for c in s:
            # if stack is not empty and top == c (last element)
            if stack and stack[-1] == c:
                stack.pop()
            else:
                stack.append(c)
        
        return "".join(stack)
    