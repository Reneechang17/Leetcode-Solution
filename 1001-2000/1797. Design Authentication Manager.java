// Medium
// Map, Queue, Design
// generate: O(1), renew: O(1), countUnexpiredTokens: O(n)，平均O(1)
// https://leetcode.cn/problems/design-authentication-manager

import java.util.*;

class AuthenticationManager {
    // DS to store the tokenId and its expiry time -> Hash Table
    // we can store the tokenId with its hash code
    // DS to clean up the expired token -> Queue
    private int timeToLive;
    private Map<String, Integer> map; // store the token and its expity time
    private Queue<int[]> que; // store [expiry time, tokenId]

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
        que = new LinkedList<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        int expiryTime = currentTime + timeToLive;
        map.put(tokenId, expiryTime);
        que.offer(new int[]{expiryTime, tokenId.hashCode()});
    }
    
    public void renew(String tokenId, int currentTime) {
        Integer expiryTime = map.get(tokenId);
        if (expiryTime != null && expiryTime > currentTime) {
            int newExpiryTime = currentTime + timeToLive;
            map.put(tokenId, newExpiryTime);
            que.offer(new int[] {newExpiryTime, tokenId.hashCode()});
        }
    }
    
    // remove the expired tokens and return the map size
    public int countUnexpiredTokens(int currentTime) {
        while (!que.isEmpty() && que.peek()[0] <= currentTime) {
            int[] expired = que.poll();
            String tokenId = getTokenIdByHash(expired[1]);
            if (tokenId != null && map.get(tokenId) <= currentTime) {
                map.remove(tokenId);
            }
        }
        return map.size();
    }

    private String getTokenIdByHash(int hash) {
        for(String key : map.keySet()) {
            if(key.hashCode() == hash) {
                return key;
            }
        }
        return null;
    }
}
