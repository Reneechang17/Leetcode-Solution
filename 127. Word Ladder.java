// Hard
// BFS, HashSet, Array
// O(m * n)
// https://leetcode.com/problems/word-ladder/

import java.util.*;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      // 將字典轉換成集合比較好遍歷
      Set<String> set = new HashSet<>(wordList);
      // 如果這個字典沒有target word：endWord，直接返回0
      if (!set.contains(endWord)) {
          return 0;
      }

      // 初始化隊列，用來做BFS用，存儲單詞和當前遍歷的層數
      Queue<String> que = new LinkedList<>();
      que.offer(beginWord);

      // 用hashset來標記已經訪問過的，避免重複訪問
      Set<String> visited = new HashSet<>();
      visited.add(beginWord);

      int level = 1; // 紀錄BFS的層數

      while (!que.isEmpty()) {
          int n = que.size();
          for (int i = 0; i < n; i++) {
              String curWord = que.poll();

              // 遍歷當前單詞的每一個字母
              char[] wordChars = curWord.toCharArray();
              for (int j = 0; j < wordChars.length; j++) {
                  char oldChar = wordChars[j];

                  // 嘗試所有替換可能
                  for (char c = 'a'; c <= 'z'; c++) {
                      wordChars[j] = c;
                      String newWord = new String(wordChars); // 已經改過的

                      if (newWord.equals(endWord)) {
                          return level + 1;
                      }

                      // 如果這個新的單詞在set中，並且沒有訪問過，就加入隊列並且標記訪問
                      if (set.contains(newWord) && !visited.contains(newWord)) {
                          que.offer(newWord);
                          visited.add(newWord);
                      }
                  }
                  wordChars[j] = oldChar; // 恢復原本的繼續搜
              }
          }
          level++;
      }
      return 0;
  }
}

/**
 * 單詞接龍：從beginWord變換到目標單詞endWord的最短轉換序列，每次只能改變一個字母，且每次變換後的單詞都要在字典wordList中
 * 
 * 這題是一個最短路徑的題，可以聯想到BFS
 * 可以把每個單詞看作是圖中的一個節點，邊表示兩個單詞之間只有一個字母不同。從beginWord開始，逐個找到一個字母不同的單詞，直到找到endWord
 * 用字典wordList來構建圖，每個單詞作為節點，兩個節點之間有邊，僅當兩個單詞之間只有一個字母不同
 * 可以用一個Hashset來存儲已經訪問過的節點，避免重複使用
 **/