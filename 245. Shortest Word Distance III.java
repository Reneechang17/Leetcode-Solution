// Medium
// Array, String
// O(N) 
// https://leetcode.com/problems/shortest-word-distance-iii/

class Solution {
  public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
      int index1 = -1, index2 = -1, minDistance = Integer.MAX_VALUE;
      boolean same = word1.equals(word2);

      for (int i = 0; i < wordsDict.length; i++) {
          // w1和w2相同的情況下
          if (same && wordsDict[i].equals(word1)) {
              // 先檢查index1是否被更新過
              if (index1 != -1) {
                  minDistance = Math.min(minDistance, i - index1);
              }
              // 如果沒有被更新過，先更新index1
              index1 = i;
          // w1和w2不同的情況下
          } else {
              if (wordsDict[i].equals(word1)) {
                  index1 = i;
                  if (index2 != -1) {
                      minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                  }
              }
              if (wordsDict[i].equals(word2)) {
                  index2 = i;
                  if (index1 != -1) {
                      minDistance = Math.min(minDistance, Math.abs(index1 - index2));
                  }
              }
          } 
      }
      return minDistance;
  }
}

/**
 * 是243的一個變形題，同樣是找出兩個單詞之間的最短距離，但是這題允許兩個單詞是相同的
 * 
 * 需要分別處理兩個單詞相同or不相同的情況
 * 如果相同，則是跟蹤該單詞上一個出現的位置，並計算當前和上一個位置之間的差值
 * 如果不同，則是跟蹤兩個單詞最近的位置，並計算兩個位置的差值（如果找到w1的話，更新index1，並檢查index2是否被更新過，如果被更新則可以找最短距離，同理找到w2的情況）
 **/