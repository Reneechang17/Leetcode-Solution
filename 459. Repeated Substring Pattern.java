// Easy
// String
// O(n)
// https://leetcode.com/problems/repeated-substring-pattern/

class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int n = s.length();
    for (int i = n / 2; i >= 1; i--) {
      if (n % i == 0) {
        int times = n / i;
        String subS = s.substring(0, i);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < times; j++) {
          sb.append(subS);
        }

        if (sb.toString().equals(s)) {
          return true;
        }
      }
    }
    return false;
  }
}

/**
 * 思路：可以從字符串的一半長度開始，逐漸減少子串長度，檢查是否可以由該子串構成原字符串
 * 如果當前的長度可以整除，才有可能是重複子串，再計算子串重複的次數（因為之後要拼接）
 **/