from typing import List

class TopVotedCandidate:

    # Time:O(n)
    def __init__(self, persons: List[int], times: List[int]):
        self.times = times
        self.leaders = []

        count = {}
        leader = -1
        max_votes = 0

        for person in persons:
            count[person] = count.get(person, 0) + 1

            if count[person] >= max_votes:
                leader = person
                max_votes = count[person]

            self.leaders.append(leader)

    # Time:O(logn)
    def q(self, t: int) -> int:
        left, right = 0, len(self.times) - 1

        while left < right:
            mid = (left + right + 1) // 2
            if self.times[mid] <= t:
                left = mid
            else:
                right = mid - 1

        return self.leaders[left]
