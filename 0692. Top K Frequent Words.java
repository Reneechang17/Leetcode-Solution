// Medium
// Sort+HashMap, PriorityQueue
// https://leetcode.cn/problems/top-k-frequent-words/

import java.util.*;

class Solution1 {
  // sort+HashMap, use when k is close to N
  // Time:O(nlogn), Space:O(n)
  public List<String> topKFrequent(String[] words, int k) {
      // 1. count frequency of each word
      Map<String, Integer> map = new HashMap<>();
      for (String word : words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }
      // 2. sort the words by freq and then lexicographical order
      List<String> list = new ArrayList<>(map.keySet());
      list.sort((a, b) -> {
          if (map.get(a).equals(map.get(b))) {
              return a.compareTo(b);
          }
          return map.get(b) - map.get(a);
      });
      // 3. return top k words
      return list.subList(0, k);
  }
}

class Solution2 {
  // PriorityQueue+HashMap: use when k is very small, k<<n
  // Time:O(nlogk),Space:O(n+k)
  public List<String> topKFrequent(String[] words, int k) {
      // 1. count the freq of each word
      Map<String, Integer> map = new HashMap<>();
      for (String word : words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }  
      // 2. use pq to maintain top k freq words
      PriorityQueue<String> pq = new PriorityQueue<>(
          (a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b)
      );
      for (String word : map.keySet()) {
          pq.offer(word);
          if (pq.size() > k) {
              pq.poll();
          }
      }
      // 3. build the res list from the heap
      List<String> res = new ArrayList<>();
      while (!pq.isEmpty()) {
          res.add(pq.poll());
      }
      Collections.reverse(res);
      return res;
  }
}
