# Time:O(nlogn), Space:O(1)

from typing import List

class Solution:
    def minimumAddedCoins(self, coins: List[int], target: int) -> int:
        coins.sort()

        # max_reach means cur can form[1, max_reach]
        max_reach = 0
        added = 0
        i = 0

        while max_reach < target:
            # if next coin <= max_reach+1, add it can form [1, max_reach_coin]
            if i < len(coins) and coins[i] <= max_reach + 1:
                max_reach += coins[i]
                i += 1

            # otherwise, add max_reach+1
            else:
                max_reach += max_reach + 1
                added += 1

        return added
    