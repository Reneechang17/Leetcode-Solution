// Medium
// Greedy, Math
// O(n)
// https://leetcode.com/problems/monotone-increasing-digits/

class Solution {
  public int monotoneIncreasingDigits(int n) {
    String s = String.valueOf(n);
    char[] chars = s.toCharArray();
    int start = s.length();

    for (int i = s.length() - 2; i >= 0; i--) {
      if (chars[i] > chars[i + 1]) {
        chars[i]--;
        start = i + 1;
      }
    }

    // 從start開始後面全部填9
    for (int i = start; i < s.length(); i++) {
      chars[i] = '9';
    }

    // 將字符數組轉回字符串 再 轉回整數
    return Integer.parseInt(String.valueOf(chars));
  }
}

/**
 * 目標是找到一個最大的數字，這個數字必須小於等於給定的數字n，且其每一位數字從左到右都是單調遞增的
 * 
 * 思路：舉例98
 * 當strNum[i - 1] > strNum[i]就不滿足單調遞增，讓strNum[i - 1]--，然後讓strNum[i]為9 => 89
 * => 從後向前遍歷，並且需要一個index來紀錄什麼時候給9，這個index之後的數字都換成9，儘量讓這個結果更大（因為要找最大）
 **/