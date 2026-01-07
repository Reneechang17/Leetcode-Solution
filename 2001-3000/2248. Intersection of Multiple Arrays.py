# Time:(n*m + k log k), Space:O(k)

from typing import Counter, List

class Solution:
    def intersection(self, nums: List[List[int]]) -> List[int]:
        n = len(nums)
        count = Counter()

        for arr in nums:
            for num in set(arr):
                count[num] += 1

        res = [num for num, freq in count.items() if freq == n]
        return sorted(res)
