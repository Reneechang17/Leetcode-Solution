# Time:O(n), Space:O(n)

from typing import List

class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n

        left_index_sum = {}
        left_count = {}

        for i in range(n):
            val = nums[i]
            if val in left_count:
                res[i] += i * left_count[val] - left_index_sum[val]
                left_index_sum[val] += i
                left_count[val] += 1
            else:
                left_index_sum[val] = i
                left_count[val] = 1

        index_sum = {}
        count = {}

        for i in range(n - 1, -1, -1):
            val = nums[i]
            if val in count:
                res[i] += index_sum[val] - i * count[val]
                index_sum[val] += i
                count[val] += 1
            else:
                index_sum[val] = i
                count[val] = 1

        return res
