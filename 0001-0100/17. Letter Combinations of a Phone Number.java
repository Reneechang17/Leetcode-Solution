// Medium
// Backtracking
// O(3^n * 4^m)
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;

class Solution {
  List<String> res = new ArrayList<>();
  public List<String> letterCombinations(String digits) {
      if(digits.length() == 0 || digits == null) return res;
      String[] numList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
      backtracking(digits, numList, 0);
      return res;
  }
  StringBuilder sb = new StringBuilder();

  private void backtracking(String digits, String[] numList, int num) {
      if(num == digits.length()) {
          res.add(sb.toString());
          return;
      }
      // 用num來獲取digits中當前的數字字符，並且把他轉換成整數索引
      String str = numList[digits.charAt(num) - '0'];
      for(int i = 0; i < str.length(); i++) {
          sb.append(str.charAt(i));

          backtracking(digits, numList, num + 1);
          sb.deleteCharAt(sb.length() - 1); // 移除上一步添加的字符
      }
  }
}

/**
 * 這題可以用回溯，因為要找出所有可能的匹配
 * 
 * 每一層的backtracking中，num用來找下一個數字，直到num的長度等於digits的長度時，收入res
 * 用回溯嘗試所有可能的字符組合，每次都把一個字符添加到sb中，然後處理下一個字母
 * 再通過deleteCharAt撤銷上一步的選擇，嘗試下一個可能的字母
 **/