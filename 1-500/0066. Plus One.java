// Easy
// Array
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/plus-one/

class Solution {
  public int[] plusOne(int[] digits) {
      // iterate from last digit
      for (int i = digits.length - 1; i >= 0; i--) {
          // if cur digit < 9, plus one and return
          if (digits[i] < 9) {
              digits[i]++;
              return digits;
          }
          // if cur is 9, change it to 0 
          digits[i] = 0;
      }
      // 所有位都已进位，数组前+1
      int[] res = new int[digits.length + 1];
      res[0] = 1; // 进位后最高位是1
      return res;
  }
}
