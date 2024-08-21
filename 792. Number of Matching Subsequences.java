// Medium
// Hash Table, Binary Search
// O(N+T*logM)
// N為映射，T*logM表示處理所有單詞的總時間
// https://leetcode.com/problems/number-of-matching-subsequences/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  public int numMatchingSubseq(String s, String[] words) {
      List<Integer>[] charPos = new List[26];
      
      // 每一個元素都是一個數組，每個list裝字母在s中出現的位置
      for (int i = 0; i < charPos.length; i++) {
          charPos[i] = new ArrayList<>();
      }

      for (int i = 0; i < s.length(); i++) {
          charPos[s.charAt(i) - 'a'].add(i);
      }

      int count = 0;
      for (String word : words) {
          int prevPos = -1;
          boolean isSub = true;
          for (char c : word.toCharArray()) {
              List<Integer> pos = charPos[c - 'a'];
              int posIndex = Collections.binarySearch(pos, prevPos + 1);
              if (posIndex < 0) posIndex = -posIndex - 1;

              if (posIndex == pos.size()) {
                  isSub = false;
                  break;
              }
              prevPos = pos.get(posIndex);
          }
          if (isSub) count++;
      }
      return count;
  }
}

/**
 * 符合子序列的個數：給定字符串s和一個字符串數組words，統計words中有多少個字符串是s的子序列
 * 
 * 這題比較難，首先需要開一個list的數組，每個元素是一個list，list裡面存儲的是s中每個字母出現的位置
 * 例如第一個元素是'a'，list裡面存儲的是s中'a'出現的位置
 * 然後遍歷words中的每個單詞，對於每個單詞，遍歷單詞中的每個字母，對於每個字母，找到在s中的位置
 * 二分查找找到第一個大於prevPos的位置，如果找不到，則表示不是子序列
 **/