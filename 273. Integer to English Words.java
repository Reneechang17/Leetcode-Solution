// Hard
// Math, String
// O(n)
// https://leetcode.com/problems/integer-to-english-words/

class Solution {
  private String[] less_than_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",  "Nineteen"};
  private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private String[] thousands = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
      if (num == 0) return "Zero";

      int i = 0;
      String words = "";

      while (num > 0) {
          if (num % 1000 != 0) // 如果當前的千位數部分不為0，需要轉換
              words = helper(num % 1000) + thousands[i] + " " + words; // 使用helper處理三位一組的數組，並加上適當單位
          num /= 1000;
          i++;
      }
      return words.trim(); // 返回結果前去掉尾部可能的多餘空格
  }

  private String helper(int num) {
      if (num == 0) 
          return ""; // 傳入為0，返回空字符串
      else if (num < 20)
          return less_than_20[num] + " "; // 小於20直接返回對應單詞
      else if (num < 100)
          return tens[num / 10] + " " + helper(num % 10); // 小於100，返回對應的十位數
      else
          return less_than_20[num / 100] + " Hundred " + helper(num % 100); // 如果大於等於100，先處理百位數，再遞歸處理十位數和個位數
  }
}

/**
 * 將非負整數轉換為英文單詞的表達式 ex. 123 => "One Hundred Twenty Three"
 * 
 * 思路： 
 * 首先要理解英文數字的結構：1. 單位（Hundred, Thousand, Million, Billion) 2. 小於20的數 3. 十位數（可以先定義）
 * 這題的edgecases比較多：例如 zero的處理，空“”的處理
 **/