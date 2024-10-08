// Easy
// Array, String
// O(n)
// https://leetcode.cn/problems/shortest-word-distance/

class Solution {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
      int index1 = -1, index2 = -1;
      int minDis = wordsDict.length; // 初始化一個較大的值用於之後比較

      for (int i = 0; i < wordsDict.length; i++) {
          if (wordsDict[i].equals(word1)) {
              index1 = i;
          } else if (wordsDict[i].equals(word2)) {
              index2 = i;
          }

          // 需要先確保兩個單詞都出現過至少一次
          if (index1 != -1 && index2 != -1) {
              minDis = Math.min(minDis, Math.abs(index1 - index2));
          }
      }
      return minDis;
  }
}

/**
 * 最短單詞距離
 * 最直接的方法就是遍歷一次列表，紀錄word1和word2的最新位置，並紀錄其索引，動態更新最小距離
 **/
