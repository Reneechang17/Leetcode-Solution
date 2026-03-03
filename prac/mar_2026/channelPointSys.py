from collections import defaultdict

class ChannelPointSystem:

    def __init__(self, cooldown: int):
        self.cooldown = cooldown
        self.rewards = {} # rewardId -> cost
        self.points = defaultdict(int) # userId -> points
        self.last_redeemed = {} # rewardId -> last redeem ts

    def addReward(self, rewardId: str, cost: int):
        self.rewards[rewardId] = cost

    def earnPoint(self, userId: str, points: int, timestamp: int):
        self.points[userId] += points

    def redeem(self, userId: str, rewardId: str, timestamp: int) -> bool:
        if rewardId not in self.rewards:
            return False
        if self.points[userId] < self.rewards[rewardId]:
            return False
        if timestamp - self.last_redeemed.get(rewardId, -float('inf')) < self.cooldown:
            return False
        self.points[userId] -= self.rewards[rewardId]
        self.last_redeemed[rewardId] = timestamp
        return True

    def getPoints(self, userId: str) -> int:
        return self.points[userId]

if __name__ == "__main__":
    sys = ChannelPointSystem(10)
    sys.addReward("r1", 500)
    sys.earnPoint("renee", 1000, 1)
    sys.earnPoint("mia", 400, 1)

    print(sys.redeem("renee", "r1", 5)) # True
    print(sys.redeem("mia", "r1", 12)) # False - cooldown
    print(sys.redeem("mia", "r1", 16)) # False - not enough points
    sys.earnPoint("mia", 200, 17)
    print(sys.redeem("mia", "r1", 18)) # True
    print(sys.getPoints("renee")) # 500
    print(sys.getPoints("mia")) # 100

    print(sys.redeem("renee", "non-exist", 20)) # False - reward doesn't exist

    sys2 = ChannelPointSystem(10)
    sys2.addReward("dance", 100)
    sys2.earnPoint("renee", 500, 1)
    print(sys2.redeem("renee", "dance", 1)) # True - first redeem
    print(sys2.redeem("renee", "dance", 11)) # True - at boundary
    