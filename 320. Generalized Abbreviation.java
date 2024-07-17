// Medium
// Backtracking
// O(n * 2^n)
// 對於每一個字符，有兩種選擇（省略or不省略），新的縮寫涉及複製當前到結果列表
// Similar: 784
// https://leetcode.com/problems/generalized-abbreviation/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> generateAbbreviations(String word) {
      List<String> res = new ArrayList<>();
      backtracking(res, new StringBuilder(), word, 0, 0);
      return res;
  }
  private void backtracking(List<String> res, StringBuilder abbr, String word, int i, int count) {
      int len = abbr.length();
      if (i == word.length()) {
          if (count > 0) abbr.append(count);
          res.add(abbr.toString());
      } else {
          backtracking(res, abbr, word, i + 1, count + 1); // 當前字符省略

          // 當前字符不省略，先處理之前省略的數量
          if (count > 0) abbr.append(count);
          abbr.append(word.charAt(i)); // 添加當前字符
          backtracking(res, abbr, word, i + 1, 0);
      }
      abbr.setLength(len);
  }
}

/**
 * 生成一個給定單詞的所有可能的縮寫形式
 * 縮寫規則： 1. 數字表示有連續省略的字母數量 2. 不能有連續的數字
 * 例如 對於一個單詞word，其可能的一些縮寫包括 4（整個單詞都替換成數字）、1ord（省略第一個字母）、w1rd..
 * 不能是13（w+ord）這類
 * 
 * 這題怎麼想到回溯？首先他提到要返回所有可能的結果，代表我們有嘗試對於每種可能找的過程，也就是A1確定之後，我們還要去確認A2A3...由此想到回溯（我知道有點硬來）
 * 這題在回溯的應用是嘗試每一個字母的兩個可能的情況 1. 省略當前字母（也就是當前改成字符數量累加，然後移動到下一個） 2. 不省略當前，就需要先紀錄之前省略的字符數量（如果有的話），然後添加當前字符
 * 也就是每一個字符都要經歷兩個嘗試（時間複雜度為2^n)，直到到單詞的結尾
 * 那我們最後要構建每一個單詞縮寫，這個時間複雜度是O(n)
 * 綜合：時間複雜度為O(n * 2^n)
 **/