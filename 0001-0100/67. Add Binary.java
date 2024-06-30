// Easy
// Math, String
// O(max(n,m))
// https://leetcode.com/problems/add-binary/

class Solution {
  public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int i = a.length() - 1, j = b.length() - 1, carry = 0;

      while (i >= 0 || j >= 0) {
          int sum = carry;
          if (i >= 0) sum += a.charAt(i--) - '0';
          if (j >= 0) sum += b.charAt(j--) - '0';
          sb.append(sum % 2);
          carry = sum / 2;
      }
      if (carry != 0) sb.append(carry);
      return sb.reverse().toString();
  }
}

/**
 * 核心思想：從兩個二進制字符串的末尾開始遍歷
 * 用變量ij指向兩個字符串末尾，carry表示當前的進位，初始為0
 * 
 * 遍歷循環的終止條件：只要有一個字符串還有沒處理完的位就繼續循環
 * 如果i有效，就將a字符串當前的位加到sum中，並且i--
 * 同理j
 * 
 * 將sum % 2加入sb中
 * 更新進位（carry）： sum / 2
 * 
 * 處理最後進位：只要carry還有就把他們加到sb中
 * 最後把sb進行反轉再toString
 **/