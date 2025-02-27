// Medium
// Hash Table, Heap, Design
// Time:O(1)->postTweet(); O(nlogn)->getNewsFeed(); O(1)->follow/unfollow
// Space:O(n)
// https://leetcode.cn/problems/design-twitter/

import java.util.*;

class Twitter {
    private int timeStamp;
    // key:userId, val:list of twitters(timestamp, tweetId)
    private Map<Integer, List<int[]>> tweets; 
    // key:userId, val: set of followers
    private Map<Integer, Set<Integer>> followers;

    public Twitter() {
        timeStamp = 0;
        tweets = new HashMap<>();
        followers = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        // add tweet with timestamp to user's tweet list
        tweets.get(userId).add(new int[]{timeStamp++, tweetId});
    }

    // Use maxHeap to get the latest 10 tweets in user's news feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // add user's tweets to pq
        if (tweets.containsKey(userId)) {
            for (int[] t : tweets.get(userId)) {
                pq.offer(t);
            }
        }
        
        // add tweets of users that the user is following
        if (followers.containsKey(userId)) {
            for (int followeeId : followers.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    for (int[] t : tweets.get(followeeId)) {
                        pq.offer(t);
                    }
                }
            }
        }

        // collect the latest 10 tweets
        int cnt = 0;
        while (!pq.isEmpty() && cnt < 10) {
            res.add(pq.poll()[1]);
            cnt++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
