// Medium
// Math
// O(n)
// https://leetcode.com/problems/string-to-integer-atoi/

class Solution {
  public int myAtoi(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }

    int index = 0, sign = 1;
    long total = 0;

    if (s.charAt(index) == '+' || s.charAt(index) == '-') {
      sign = s.charAt(index) == '+' ? 1 : -1;
      index++;
    }

    while (index < s.length()) {
      char cur = s.charAt(index);
      if (!Character.isDigit(cur)) {
        break;
      }

      int digit = cur - '0';

      if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      total = total * 10 + digit;
      index++;
    }
    return (int) total * sign;
  }
}

/**
 * 將一個字符串轉換為整數，需要處理以下幾個問題：
 * 1. 去掉所有開頭的空格
 * 2. 判斷正負號
 * 3. 如果數值部分後接的是非數字字符，這些字符會被忽略，只返回前面的數值部分
 * 4. 如果字符串在忽略前面的空格字符後不是一個有效的整數（或是已經結束），則不進行轉換
 * 5. 如果整數數值超出了32位有符號整數的範圍，則返回INT_MAX（2^31 - 1）或INT_MIN（-2^31），需要截取在這個範圍之內
 **/
