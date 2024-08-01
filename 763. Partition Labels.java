// Medium
// String, Greedy
// O(n)
// https://leetcode.com/problems/partition-labels/

import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<Integer> partitionLabels(String s) {
      List<Integer> list = new LinkedList<>();
      int[] edge = new int[26];
      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {
          edge[chars[i] - 'a'] = i;
      }

      int index = 0;
      int last = -1;
      for (int i = 0; i < chars.length; i++) {
          index = Math.max(index, edge[chars[i] - 'a']);
          if (i == index) {
              list.add(i - last);
              last = i;
          }
      }
      return list;
  }
}

/**
 * 劃分字母區間：把字符串劃分成盡可能多的片段，同一個字母最多出現在一個片段中，返回一個列表表示每個字符串片段的長度的列表
 * 也就是說把相同的字母圈在一個區間裡，找字母出現的最邊界
 * 
 * 思路：
 * 先統計每一個字母最後出現的下標，因為字符串只會有小寫字母，也就是26個，可以直接用數組計數
 * 再從頭遍歷字符串，並且更新每個字母出現的最遠下標，如果字母最遠出現的位置的下標和當前下標相同，代表找到分割點
 * 則將要添加的片段長度到list裡，即index+1，所以last的初始值為-1
 * 再更新上一個片段的最後一個位置給last
 **/