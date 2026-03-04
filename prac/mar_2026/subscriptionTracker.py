from collections import defaultdict

class SubscriptionTracker:
    def __init__(self):
        self.subs = defaultdict(list) # userId -> list of [start, end]
    
    def subscribe(self, userId: str, start: int, end: int):
        self.subs[userId].append([start, end])
        self.subs[userId].sort(key=lambda x:x[0])

        merged = []
        for interval in self.subs[userId]:
            if merged and interval[0] <= merged[-1][1]:
                merged[-1][1] = max(merged[-1][1], interval[1])
            else:
                merged.append(interval)
        self.subs[userId] = merged

    def getSubscriptions(self, userId: str) -> list[list[int]]:
        return self.subs[userId]
    
    def getLongestStreak(self, userId: str) -> int:
        if not self.subs[userId]:
            return 0
        return max(end - start for start, end in self.subs[userId])


if __name__ == "__main__":
    t = SubscriptionTracker()
    t.subscribe("alice", 1, 3)
    t.subscribe("alice", 2, 6)   # overlaps, merge
    t.subscribe("alice", 8, 10)
    print(t.getSubscriptions("alice"))   # [[1,6],[8,10]]
    print(t.getLongestStreak("alice"))   # 5

    t.subscribe("alice", 6, 8)   # adjacent, merge all
    print(t.getSubscriptions("alice"))   # [[1,10]]
    print(t.getLongestStreak("alice"))   # 9

    # new user
    t.subscribe("bob", 5, 7)
    print(t.getSubscriptions("bob"))     # [[5,7]]
    print(t.getLongestStreak("bob"))     # 2
