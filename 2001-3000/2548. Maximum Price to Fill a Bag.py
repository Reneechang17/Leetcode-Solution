# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def maxPrice(self, items: List[List[int]], capacity: int) -> float:
        items.sort(key=lambda x: x[0] / x[1], reverse=True)

        total = 0.0
        remaining = capacity

        for price, weight in items:
            if remaining >= weight:
                total += price
                remaining -= weight
            else:
                total += price * (remaining / weight)
                remaining = 0
                break
        
        if remaining > 0:
            return -1.0
        return total
    