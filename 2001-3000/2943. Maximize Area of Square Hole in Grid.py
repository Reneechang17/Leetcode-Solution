# Time:O(k logk), Space:O(1)

from typing import List

class Solution:
    def maximizeSquareHoleArea(
        self, n: int, m: int, hBars: List[int], vBars: List[int]
    ) -> int:
        def longest_consecutive(arr):
            if not arr:
                return 0

            arr.sort()
            max_len = cur_len = 1
            for i in range(1, len(arr)):
                if arr[i] == arr[i - 1] + 1:
                    cur_len += 1
                    max_len = max(max_len, cur_len)
                else:
                    cur_len = 1
            return max_len

        h_len = longest_consecutive(hBars)
        v_len = longest_consecutive(vBars)

        side = min(h_len, v_len) + 1

        return side * side
    