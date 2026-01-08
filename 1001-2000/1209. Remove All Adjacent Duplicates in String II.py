# Medium
# Stack
# Time:O(n), Space:O(n)
# https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []  # (char, count)

        for char in s:
            if stack and stack[-1][0] == char:
                stack[-1] = (char, stack[-1][1] + 1)

                if stack[-1][1] == k:
                    stack.pop()
            else:
                stack.append((char, 1))

        res = []
        for char, count in stack:
            res.append(char * count)

        return "".join(res)
