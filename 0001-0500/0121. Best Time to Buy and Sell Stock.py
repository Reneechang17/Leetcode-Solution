from typing import *

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_price = float('inf')
        max_profit = 0

        for p in prices:
            min_price = min(min_price, p)
            max_profit = max(max_profit, p - min_price)

        return max_profit
            