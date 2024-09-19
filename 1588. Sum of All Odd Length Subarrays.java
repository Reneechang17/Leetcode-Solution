// Easy
// Prefix Sum, Math
// O(n)
// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
      int n = arr.length;
      int sum = 0;

      for (int i = 0; i < n; i++) {
          int totalSubarrays = (i + 1) * (n - i); // 所有包含arr[i]的子數組總數
          int oddSubarrays = (totalSubarrays + 1) / 2;

          sum += oddSubarrays * arr[i];
      }
      return sum;
  }
}

/**
 * 所有奇數長度子數組的和，子數組指數組中連續的元素
 * 
 * 思路：首先可以想到用暴力枚舉所有長度為奇數的子數組，然後計算他們的和，通過兩層循環可以實現，第一層循環選擇起始位置，第二個循環枚舉所有奇數長度的子數組
 * 但是這樣的時間複雜度有點高，所以需要優化：對於數組的每一個元素arr[i]，可以計算它在多少個奇數長度的子數組中出現，然後把它所有子數組中的貢獻都加起來
 * 也就是說我們不需要逐個去枚舉生成所有子數組，而是直接計算每個元素對最終答案的貢獻次數即可
 * 
 * 具體：對於每個arr[i]，計算它能被包含在多少個子數組中（包含偶數和奇數長度的子數組）
 * 然後從這些組合中找到包含這個元素的奇數長度的子數組個數，累加這個數的貢獻
 **/