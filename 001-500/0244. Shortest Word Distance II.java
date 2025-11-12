// Medium
// Hash Table, Two Pointers
// https://leetcode.cn/problems/shortest-word-distance-ii/

import java.util.*;

class WordDistance {
  Map<String, List<Integer>> map;

  // 構造函數可以用哈希表
  public WordDistance(String[] wordsDict) {
      map = new HashMap<>();
      for (int i = 0; i < wordsDict.length; i++) {
          String word = wordsDict[i];
          if (!map.containsKey(word)) {
              map.put(word, new ArrayList<>());
          }
          map.get(word).add(i);
      }
  }
  
  // 找最短的單詞路徑可以用雙指針
  public int shortest(String word1, String word2) {
      List<Integer> list1 = map.get(word1);
      List<Integer> list2 = map.get(word2);
      int minDis = Integer.MAX_VALUE;
      int i = 0, j = 0;

      while (i < list1.size() && j < list2.size()) {
          int index1 = list1.get(i), index2 = list2.get(j);
          if (index1 < index2) {
              minDis = Math.min(minDis, index2 - index1);
              i++;
          } else {
              minDis = Math.min(minDis, index1 - index2);
              j++;
          }
      }
      return minDis;
  }
}

/**
 * 最短單詞距離：設計一個類來接受一系列單詞，能夠多次有效地計算指定兩個單詞之間的最短距離
 **/
