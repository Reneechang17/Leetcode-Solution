// Medium
// Hash Table, Heap
// Time:O(1)->postTweet(); O(nlogn)->getNewsFeed(); O(1)->follow/unfollow
// Space:O(n)
// https://leetcode.cn/problems/design-twitter/

import java.util.*;

class Twitter {
    
    private int time = 0;
    private Map<Integer, List<int[]>> userTweets;
    private Map<Integer, Set<Integer>> userFollows;

    public Twitter() {
        time = 0;
        userTweets = new HashMap<>();
        userFollows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userTweets.containsKey(userId)) {
            userTweets.put(userId, new ArrayList<>());
        }

        userTweets.get(userId).add(new int[] { time++, tweetId });
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        if (userTweets.containsKey(userId)) {
            for (int[] t : userTweets.get(userId)) {
                pq.offer(t);
            }
        }

        if (userFollows.containsKey(userId)) {
            for (int followeeId : userFollows.get(userId)) {
                if (userTweets.containsKey(followeeId)) {
                    for (int[] t : userTweets.get(followeeId)) {
                        pq.offer(t);
                    }
                }
            }
        }

        int cnt = 0;
        while (!pq.isEmpty() && cnt < 10) {
            res.add(pq.poll()[1]);
            cnt++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userFollows.containsKey(followerId)) {
            userFollows.put(followerId, new HashSet<>());
        }
        userFollows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollows.containsKey(followerId)) {
            userFollows.get(followerId).remove(followeeId);
        }
    }
}
