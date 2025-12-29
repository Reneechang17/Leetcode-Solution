# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def maximumTastiness(self, price: List[int], k: int) -> int:
        price.sort()

        def can_select(min_diff):
            # find the diff >= min_diff
            count = 1
            last = price[0]

            for i in range(1, len(price)):
                if price[i] - last >= min_diff:
                    count += 1
                    last = price[i]
                    if count == k:
                        return True
            return False

        left, right = 0, price[-1] - price[0]
        ans = 0

        while left <= right:
            mid = (left + right) // 2
            if can_select(mid):
                ans = mid
                left = mid + 1
            else:
                right = mid - 1

        return ans
    