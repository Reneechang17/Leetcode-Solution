// Medium
// Array, Hash Table
// O(N) -> WordDistance
// O(word1 + word2) -> shortest
// https://leetcode.com/problems/shortest-word-distance-ii/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WordDistance {
  Map<String, List<Integer>> map;

  public WordDistance(String[] wordsDict) {
    map = new HashMap<>();
    for (int i = 0; i < wordsDict.length; i++) {
      map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);
    int ans = Integer.MAX_VALUE;
    int i = 0, j = 0;

    while (i < l1.size() && j < l2.size()) {
      int idx1 = l1.get(i), idx2 = l2.get(j);
      if (idx1 < idx2) {
        ans = Math.min(ans, idx2 - idx1);
        i++;
      } else {
        ans = Math.min(ans, idx1 - idx2);
        j++;
      }
    }
    return ans;
  }
}

/**
 * 需要設計一個類來接受一系列單詞，能夠多次有效地計算指定兩個單詞之間的最短距離
 * 
 * 類中包含兩個元素
 * 1. 構造函數：接受一個字符串數組，初始化一個哈希表來存儲每個單詞及其出現位置的索引列表
 * 每次遇到一個新單詞，先檢查其是否已經在哈希表中，如果不在，則創建一個新的列表
 * 2. 返回兩個單詞最短距離的方法：使用雙指針來找到可能的最短距離
 **/

/**
      map = new HashMap<>();
      for (int i = 0; i < wordsDict.length; i++) {
          map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
      }
          
      可以寫成：
        wordIndexMap = new HashMap<>();
        for (int index = 0; index < wordsDict.length; index++) {
            String word = wordsDict[index];
            if (!wordIndexMap.containsKey(word)) {
                wordIndexMap.put(word, new ArrayList<>());
            }
            wordIndexMap.get(word).add(index);
        }
 **/
