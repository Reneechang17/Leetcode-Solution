// Medium
// Hash Table, Sorting
// O(n logn)
// https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String frequencySort(String s) {
      Map<Character, Integer> count = new HashMap<>();
      for (char c : s.toCharArray()) {
          count.put(c, count.getOrDefault(c, 0) + 1);
      }

      List<Character> characters = new ArrayList<>(count.keySet());
      characters.sort((a, b) -> count.get(b) - count.get(a));

      StringBuilder sb = new StringBuilder();
      for (char c : characters) {
          int words = count.get(c);
          for (int i = 0; i < words; i++) {
              sb.append(c);
          }
      }
      return sb.toString();
  }
}

/**
 * 這種出現：按照x個數（那就是要計算個數）以及升降序（可能需要排序）的就可以聯想哈希表+排序這個組合
 * Note: 有排序的話時間複雜度就會有一個logn
 * 
 * 首先先用哈希表計算字符串中每一個元素出現的次數
 * 再依照key來進行sorting
 * 因為需要返回一個字符串，按照每個字符出現的頻率降序排列，那麼還要遍歷一下排好序的list將元素打印出來
 * 這裡用的是StringBuilder來做拼接，最後toString
 **/