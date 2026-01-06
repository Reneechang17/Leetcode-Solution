# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        left, right = 0, len(s) - 1
        while left < right:
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1

        start = 0
        for i in range(len(s) + 1):
            if i == len(s) or s[i] == " ":
                left, right = start, i - 1
                while left < right:
                    s[left], s[right] = s[right], s[left]
                    left += 1
                    right -= 1
                start = i + 1
    