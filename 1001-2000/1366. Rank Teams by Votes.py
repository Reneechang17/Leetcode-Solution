# Time:O(n), Space:O(1)

from typing import List

class Solution:
    def rankTeams(self, votes: List[str]) -> str:
        if len(votes) == 1:
            return votes[0]
        
        count = {team: [0] * len(votes[0]) for team in votes[0]}

        for vote in votes:
            for i, team in enumerate(vote):
                count[team][i] += 1
        
        team = sorted(votes[0], key=lambda t: ([-v for v in count[t]], t)) 
        
        return ''.join(team)
    