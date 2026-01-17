# Time:O(nlogn + mlogn), Space:O(n)

from typing import List

class Solution:
    def fullBloomFlowers(
        self, flowers: List[List[int]], people: List[int]
    ) -> List[int]:
        starts = []
        ends = []

        for start, end in flowers:
            starts.append(start)
            ends.append(end + 1)

        starts.sort()
        ends.sort()

        def bs_right(arr, target):
            # find first pos > target
            left, right = 0, len(arr)
            while left < right:
                mid = (left + right) // 2
                if arr[mid] <= target:
                    left = mid + 1
                else:
                    right = mid
            return left

        def bs_left(arr, target):
            # find first pos >= target
            left, right = 0, len(arr)
            while left < right:
                mid = (left + right) // 2
                if arr[mid] < target:
                    left = mid + 1
                else:
                    right = mid
            return left

        res = []
        for person in people:
            bloomed = bs_right(starts, person)
            wilted = bs_left(ends, person + 1)
            res.append(bloomed - wilted)

        return res
