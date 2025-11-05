# Medium
# Queue
# Time:O(nlogn) ,Space:O(n)
# https://leetcode.cn/problems/reveal-cards-in-increasing-order/

from typing import List
from collections import deque

class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        n = len(deck)
        deck.sort()

        idx = deque(range(n))
        res = [0] * n

        for card in deck:
            i = idx.popleft()
            res[i] = card

            if idx:
                idx.append(idx.popleft())
        
        return res
