# Time:O(nlogk), Space:O(k)

import heapq
from typing import List

class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        # (min_value, list's index, element's index)
        heap = []
        max_val = float("-inf")

        for i in range(len(nums)):
            heapq.heappush(heap, (nums[i][0], i, 0))
            max_val = max(max_val, nums[i][0])

        min_range = [float("-inf"), float("inf")]

        while heap:
            min_val, list_idx, elem_idx = heapq.heappop(heap)

            if max_val - min_val < min_range[1] - min_range[0]:
                min_range = [min_val, max_val]

            if elem_idx + 1 < len(nums[list_idx]):
                next_val = nums[list_idx][elem_idx + 1]
                heapq.heappush(heap, (next_val, list_idx, elem_idx + 1))
                max_val = max(max_val, next_val)
            else:
                break

        return min_range
