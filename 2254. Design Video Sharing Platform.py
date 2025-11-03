# Hard
# Design
# https://leetcode.cn/problems/design-video-sharing-platform/

import heapq
from collections import defaultdict
from typing import *

class VideoSharingPlatform:

    def __init__(self):
        # here we figure out the data structures we need.
        self.videos = {} # videoId -> video content
        self.views = defaultdict(int) # videoId -> view count
        self.likes = defaultdict(int) # videoId -> like count
        self.dislikes = defaultdict(int) # videoId -> dislike count
        self.available_ids = [] # min heal for reusable ids
        self.next_id = 0 # next new id

    def upload(self, video: str) -> int:
        # get the smallest available id
        if self.available_ids:
            video_id = heapq.heappop(self.available_ids)
        else:
            video_id = self.next_id
            self.next_id += 1
        
        self.videos[video_id] = video
        return video_id
    
    def remove(self, videoId: int) -> None:
        if videoId in self.videos:
            del self.videos[videoId]

            # clean related-data
            self.views.pop(videoId, None)
            self.likes.pop(videoId, None)
            self.dislikes.pop(videoId, None)
            # Ids are reusable
            heapq.heappush(self.available_ids, videoId)
    
    def watch(self, videoId: int, startMinute: int, endMinute: int) -> str:
        if videoId not in self.videos:
            return "-1"
        
        video = self.videos[videoId]
        self.views[videoId] += 1

        end = min(endMinute, len(video) - 1)
        return video[startMinute:end + 1]

    def like(self, videoId: int) -> None:
        if videoId in self.videos:
            self.likes[videoId] += 1
    
    def dislike(self, videoId: int) -> None:
        if videoId in self.videos:
            self.dislikes[videoId] += 1
    
    def getLikesAndDislikes(self, videoId: int) -> List[int]:
        if videoId not in self.videos:
            return [-1]
        return [self.likes[videoId], self.dislikes[videoId]]
    
    def getViews(self, videoId: int) -> int:
        if videoId not in self.videos:
            return -1
        return self.views[videoId]
        