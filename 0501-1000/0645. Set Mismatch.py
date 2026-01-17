# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n = len(nums)
        dup = -1

        for num in nums:
            index = abs(num) - 1
            if nums[index] < 0:
                dup = abs(num)
            else:
                nums[index] = -nums[index]

        missing = -1
        for i in range(n):
            if nums[i] > 0:
                missing = i + 1
                break

        return [dup, missing]
