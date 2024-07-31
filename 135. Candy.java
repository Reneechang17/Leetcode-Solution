// Hard
// Array, Greedy
// O(n)
// https://leetcode.com/problems/candy/

class Solution {
  public int candy(int[] ratings) {
      int n = ratings.length;
      int[] candyArr = new int[n];
      candyArr[0] = 1;
      
      // 先考慮右邊評分比左邊評分大的情況（從前向後遍歷）
      for (int i = 1; i < n; i++) {
          // 當當前比左邊的大時，當前糖果就是左邊的+1，否則就是1
          candyArr[i] = (ratings[i] > ratings[i - 1] ? candyArr[i - 1] + 1 : 1);
      }

      // 再考慮左邊評分比右邊評分大的情況
      // 從後向前遍歷，從倒數第二個開始，因為前一輪已經把最後一個算好了
      for (int i = n - 2; i >= 0; i--) {
          if (ratings[i] > ratings[i + 1]) {
              candyArr[i] = Math.max(candyArr[i], candyArr[i + 1] + 1);
          }
      }

      int ans = 0;
      for (int num : candyArr) {
          ans += num;
      }
      return ans;
  }
}

/**
 * 題意：有N個孩子來分糖果，要求為1.每個人至少有一個糖果 2.評分高的要比評分低的獲得更多糖果
 * 
 * 那麼要決定先比較孩子的右邊還是先比較孩子的左邊
 * 
 * 思路：可以先確定右邊評分比左邊評分大的情況（從前向後遍歷），此時局部最優，只要右邊評分比左邊大，右邊孩子的糖果就+1
 * 再從後向前遍歷，確定左邊評分大於右邊評分的情況
 **/