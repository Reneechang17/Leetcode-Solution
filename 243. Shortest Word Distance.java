// Easy
// Array, String
// O(n)
// https://leetcode.com/problems/shortest-word-distance/

class Solution {
  public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int index1 = -1, index2 = -1;
    int minDistance = wordsDict.length; // 初始化一個較大的數

    for (int i = 0; i < wordsDict.length; i++) {
      if (wordsDict[i].equals(word1)) {
        index1 = i;
      } else if (wordsDict[i].equals(word2)) {
        index2 = i;
      }

      // 確保兩個單詞都已經找到過至少一次
      if (index1 != -1 && index2 != -1) {
        minDistance = Math.min(minDistance, Math.abs(index1 - index2));
      }
    }
    return minDistance;
  }
}

/**
 * 在給定的單詞列表中找到兩個指定單詞之間的最短距離
 * 
 * 最直接的方法就是遍歷一次列表，紀錄word1和word2的最新位置，並紀錄其索引，動態更新最小距離
 **/