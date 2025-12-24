# Time:O(mlogm + n), Space:O(1)

from typing import List

class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        total_apples = sum(apple)

        # large box first
        capacity.sort(reverse=True)

        boxes = 0
        cur_cap = 0

        for cap in capacity:
            cur_cap += cap
            boxes += 1

            if cur_cap >= total_apples:
                return boxes
        return boxes
    