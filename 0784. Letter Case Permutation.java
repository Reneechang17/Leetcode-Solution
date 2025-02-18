// Medium
// Backtracking
// O(2^n)
// Similar: 320
// https://leetcode.com/problems/letter-case-permutation/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> letterCasePermutation(String s) {
      List<String> res = new ArrayList<>();
      backtracking(s.toCharArray(), 0, res, new StringBuilder());
      return res;
  }

  private void backtracking(char[] chars, int index, List<String> res, StringBuilder cur) {
      if (index == chars.length) {
          res.add(cur.toString());
          return;
      }
      char ch = chars[index];
      if (Character.isLetter(ch)) {
          // option1: 當前字母小寫
          cur.append(Character.toLowerCase(ch));
          backtracking(chars, index + 1, res, cur);
          cur.deleteCharAt(cur.length() - 1);

          // option2: 當前字母大寫
          cur.append(Character.toUpperCase(ch));
          backtracking(chars, index + 1, res, cur);
          cur.deleteCharAt(cur.length() - 1);
      } else {
          // 數字：直接添加
          cur.append(ch);
          backtracking(chars, index + 1, res, cur);
          cur.deleteCharAt(cur.length() - 1);
      }
  }
}

/**
 * 給定一個字符串，包含數字和字母（可能是大寫or小寫），要求生成該字符串的所有可能的字母大小寫變體
 * 
 * 這題的思路和320類似，但是比較好理解，核心在於對每個字母進行大小寫轉換的選擇，如果遇到數字就保持不變
 **/