// Medium
// DP
// O(n)
// https://leetcode.com/problems/ugly-number-ii/

class Solution {
  public int nthUglyNumber(int n) {
      int[] ugly = new int[n];
      ugly[0] = 1; // 第一個醜數就是1
      int i2 = 0, i3 = 0, i5 = 0; // 初始化三個指針
      int factor2 = 2, factor3 = 3, factor5 = 5; // 初始化三個因子

      for (int i = 1; i < n; i++) {
          int min = Math.min(Math.min(factor2, factor3), factor5); // 找到當前最小的醜數
          ugly[i] = min; // 將最小的醜數添加到數組中

          // 更新指針和因子
          if (min == factor2) factor2 = 2 * ugly[++i2];
          if (min == factor3) factor3 = 3 * ugly[++i3];
          if (min == factor5) factor5 = 5 * ugly[++i5];
      }
      return ugly[n - 1];
  }
}

/**
 * 給定一個整數n，找到第n個整數
 * 醜數：指只包含質因數235的正整數，第一個醜數為1
 * 
 * 思路：可以用dp來做，構建一個醜數數組，確保每個醜數都是前面的醜數都是乘以2，3，5來的
 * 結合三指針技術，分別代表乘以2，3，5的位置，開始時，所有指針都指向數組的第一個位置
 * 從ugly[1]到ugly[n-1]，每次都從ugly[i2]*2、ugly[i3]*3、ugly[i5]*5 中取其中最小的放入ugly數組
 **/