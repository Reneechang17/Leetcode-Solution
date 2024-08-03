// Medium
// Backtracking, String
// O(n^2)
// Similar: 842
// https://leetcode.com/problems/additive-number/

class Solution {
  public boolean isAdditiveNumber(String num) {
    int n = num.length();

    // 嘗試第一個數字不同長度的可能性，第一個數字的長度不超過總長度的一半
    for (int i = 1; i <= n / 2; i++) {
      if (num.charAt(0) == '0' && i > 1)
        continue;
      
      // 嘗試第二個數字不同長度的可能性，第二個數字的起始位置為i
      for (int j = 1; i + j < n; j++) {
        if (num.charAt(i) == '0' && j > 1)
          continue;
        if (backtracking(num, i, j)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean backtracking(String num, int firstEnd, int secondLen) {
    // 解析第一個數字
    long first = Long.parseLong(num.substring(0, firstEnd));
    int secondStart = firstEnd;
    int secondEnd = firstEnd + secondLen;

    // 如果第二個數字的結束為止超過的字符串的長度，直接返回false
    if (secondEnd > num.length())
      return false;

    // 解析第二個數字
    long second = Long.parseLong(num.substring(secondStart, secondEnd));
    String sum;
    long temp;

    // 檢查剩餘數字
    for (int index = secondEnd; index < num.length(); index += sum.length()) {
      temp = second;
      second += first;
      first = temp;
      sum = String.valueOf(second);
      if (!num.startsWith(sum, index))
        return false;
    }
    return true;
  }
}

/**
 * 這題的題意類似842題，要求判斷一個數字字符串是否是一個加性數列，定義為至少包含三個數字的序列，序列中的每個數字都是前兩個數字的和（類似斐波那契序列）
 * 
 * 這題的話思路類似但是實現方式有點不同，不過都是透過回溯嘗試所有可能的數字長度組合
 * 有兩個可以剪枝的部分 1. 當前數字開頭是0，直接剪枝 2. 計算出下一個數字大於字符串的剩餘部分，直接剪枝
 **/