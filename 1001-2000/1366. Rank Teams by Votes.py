# Time:O(n² log n), Space:O(n²) 

from typing import List

class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        if len(votes) == 1:
            return votes[0]

        n = len(votes[0])
        count = {team: [0] * n for team in votes[0]}

        for vote in votes:
            for i, team in enumerate(vote):
                count[team][i] += 1

        teams = list(votes[0])
        teams.sort(key=lambda x: ([-c for c in count[x]], x))

        return "".join(teams)

    