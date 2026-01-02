# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def minCost(self, nums: List[int], costs: List[int]) -> int:
        n = len(nums)

        min_stack = [0]
        max_stack = [0]

        c = [0] * n

        for i in range(1, n):
            min_cost = float("inf")

            while min_stack and nums[min_stack[-1]] > nums[i]:
                min_cost = min(min_cost, c[min_stack[-1]])
                min_stack.pop()
            min_stack.append(i)

            while max_stack and nums[max_stack[-1]] <= nums[i]:
                min_cost = min(min_cost, c[max_stack[-1]])
                max_stack.pop()
            max_stack.append(i)

            c[i] = min_cost + costs[i]

        return c[n - 1]
