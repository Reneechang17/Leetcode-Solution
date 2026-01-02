# Time:O(nlogn), Space:O(n)

from typing import Counter, List

class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        losses = Counter()
        players = set()

        for winner, loser in matches:
            players.add(winner)
            players.add(loser)
            losses[loser] += 1

        no_loss = []
        one_loss = []

        for p in players:
            if losses[p] == 0:
                no_loss.append(p)
            elif losses[p] == 1:
                one_loss.append(p)

        return [sorted(no_loss), sorted(one_loss)]
    