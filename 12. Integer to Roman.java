// Medium
// Greedy, String
// O(1)
// https://leetcode.com/problems/integer-to-roman/

class Solution {
  public String intToRoman(int num) {
      int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < values.length; i++) {
          while (num >= values[i]) {
              sb.append(symbols[i]);
              num -= values[i];
          }
      }
      return sb.toString();
  }
}

/**
 * 將一串整數轉換成羅馬數字符號
 * 
 * 羅馬數構建規則：1. 一個羅馬數字重複幾次，代表這個數的幾倍
 * 2. 右加左減
 * 
 * 思路：
 * 透過例子發現我們可以優先處理高位的數值，那麼按照數值大小裝羅馬數字到列表，由高到低處理每個數字
 * 可以把4，9這兩個題目提到的特殊情況也加入列表裡面，這樣就不用特別計算特殊情況了
 * 
 * 時間複雜度：雖然有一個循環，但是列表只有13個並且輸入的數據量有限
 **/