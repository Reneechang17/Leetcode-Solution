# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums)
        res = []
        for i in range(n):
            char = "1" if nums[i][i] == "0" else "0"
            res.append(char)

        return "".join(res)
    