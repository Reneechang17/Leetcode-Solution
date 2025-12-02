# Medium
# Design
# https://leetcode.cn/problems/design-twitter/

from typing import *
from collections import defaultdict
import heapq

class Twitter:

    def __init__(self):
        self.tweets = defaultdict(list) # useriId -> [(timestamp, tweetId)]
        self.following = defaultdict(set) # userId -> {followeeId}
        self.timestamp = 0

    # O(1)
    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append((self.timestamp, tweetId))
        self.timestamp += 1

    # O(nlogn)
    def getNewsFeed(self, userId: int) -> List[int]:
        heap = []

        if userId in self.tweets:
            for t in self.tweets[userId]:
                heapq.heappush(heap, (-t[0], t[1]))

        for followeeId in self.following[userId]:
            if followeeId in self.tweets:
                for t in self.tweets[followeeId]:
                    heapq.heappush(heap, (-t[0], t[1]))

        res = []
        for _ in range(10):
            if not heap:
                break
            res.append(heapq.heappop(heap)[1])
        return res
    
    # O(1)
    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId != followeeId:
            self.following[followerId].add(followeeId)

    # O(1)
    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.following[followerId].discard(followeeId)
