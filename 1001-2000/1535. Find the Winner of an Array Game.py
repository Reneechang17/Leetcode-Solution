# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def getWinner(self, arr: List[int], k: int) -> int:
        if k >= len(arr):
            return max(arr)

        winner = arr[0]
        wins = 0

        for i in range(1, len(arr)):
            if winner > arr[i]:
                wins += 1
            else:
                winner = arr[i]
                wins = 1

            if wins == k:
                return winner

        return winner 
    