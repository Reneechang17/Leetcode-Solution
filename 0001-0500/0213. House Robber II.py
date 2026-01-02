# Time:O(n), Space:O(1)

# two cases: rob[0, n-2](don't rob last one)
# or rob[1, n-1](don't rob first one)

from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return max(nums)

        def rob_helper(arr):
            prev2, prev1 = 0, 0
            for num in arr:
                cur = max(prev1, prev2 + num)
                prev2 = prev1
                prev1 = cur

            return prev1

        rob1 = rob_helper(nums[:-1])
        rob2 = rob_helper(nums[1:])

        return max(rob1, rob2)
