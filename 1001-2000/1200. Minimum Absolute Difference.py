# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()

        min_diff = min(arr[i + 1] - arr[i] for i in range(len(arr) - 1))

        res = []
        for i in range(len(arr) - 1):
            if arr[i + 1] - arr[i] == min_diff:
                res.append([arr[i], arr[i + 1]])
        return res
    