// Medium
// Map, Queue, Design
// generate: O(1), renew: O(1), countUnexpiredTokens: O(n)，平均O(1)
// https://leetcode.com/problems/design-authentication-manager

import java.util.*;

class AuthenticationManager {
  private int timeToLive;
  private Map<String, Integer> map; // store token and its expiry time
  private Queue<int[]> que; // store [expiry time, tokenId]

  public AuthenticationManager(int timeToLive) {
      this.timeToLive = timeToLive;
      map = new HashMap<>();
      que = new LinkedList<>();
  }
  
  public void generate(String tokenId, int currentTime) {
      int expiryTime = currentTime + timeToLive;
      map.put(tokenId, expiryTime);
      que.offer(new int[] {expiryTime, tokenId.hashCode()});
  }
  
  public void renew(String tokenId, int currentTime) {
      // 檢查token是否存在且沒過期
      Integer expiryTime = map.get(tokenId);
      if (expiryTime != null && expiryTime > currentTime) {
          int newExpiryTime = currentTime + timeToLive;
          map.put(tokenId, newExpiryTime);
          que.offer(new int[]{newExpiryTime, tokenId.hashCode()});
      }
  }
  
  public int countUnexpiredTokens(int currentTime) {
      // 清理過期token
      while (!que.isEmpty() && que.peek()[0] <= currentTime) {
          int[] expired = que.poll();
          String tokenId = getTokenIdByHash(expired[1]);
          if (tokenId != null && map.get(tokenId) <= currentTime) {
              map.remove(tokenId);
          }
      }
      return map.size();
  }

  // 根據tokenId的哈希值獲取tokenId
  private String getTokenIdByHash(int hash) {
      for (String key : map.keySet()) {
          if (key.hashCode() == hash) {
              return key;
          }
      }
      return null;
  }
}

/**
 * 設計一個驗證系統來管理token的生成、更新和過期。token具有一定的有效期，在有效期內可以續期和計數
 * 
 * 思路：可以使用哈希表存儲tokenId以及其對應的過期時間
 * 由於我們需要高效的清理過期token，可以使用優先隊列來存儲token的過期時間和tokenId，按照過期時間排序token
 * Note：由於tokenId是唯一的，可以使用tokenId的哈希值來標識token
 *      並且操作過程比較複雜，需要儘量確保每個操作的時間複雜度盡可能為O(1)~O(logn)
 **/