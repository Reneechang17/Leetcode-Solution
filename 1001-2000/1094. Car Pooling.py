# Time:O(n+m), Space:O(m)

from typing import List

class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        max_loc = 0
        for num, start, end in trips:
            max_loc = max(max_loc, end)

        diff = [0] * (max_loc + 1)

        for num, start, end in trips:
            diff[start] += num
            diff[end] -= num

        cur = 0
        for change in diff:
            cur += change
            if cur > capacity:
                return False

        return True
    