class Leaderboard:

    def __init__(self):
        # playerID -> total score
        self.scores = {}

    # O(1)
    def addScore(self, playerId: int, score: int) -> None:
        if playerId not in self.scores:
            self.scores[playerId] = 0
        self.scores[playerId] += score
    
    # O(nlogn)
    def top(self, K: int) -> int:
        all_scores = sorted(self.scores.values(), reverse=True)
        return sum(all_scores[:K])
    
    # O(1)
    def reset(self, playerId: int) -> None:
        self.scores[playerId] = 0

class Leaderboard:

    def __init__(self):
        self.scores = {}

    def addScore(self, playerId: int, score: int) -> None:
        self.scores[playerId] = self.scores.get(playerId, 0) + score

    def top(self, K: int) -> int:
        import heapq
        return sum(heapq.nlargest(K, self.scores.values()))

    def reset(self, playerId: int) -> None:
        del self.scores[playerId]
    