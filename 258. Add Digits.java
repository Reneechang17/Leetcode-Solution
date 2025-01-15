// Easy
// Math
// Time:O(logn), Space:O(1)
//   - each iteration, the number of digits is reduced by one(n -> n/10)
// https://leetcode.cn/problems/add-digits/

class Solution {
  public int addDigits(int num) {
      int sum = 0;
      while (num != 0) {
          sum += num % 10;
          num /= 10;
          if (num == 0) {
              if (sum < 10) {
                  return sum;
              } else {
                  num = sum; 
                  sum = 0;
              }
          }
      }
      return sum;
  }
}

// 57
// sum = 7, num = 5
// sum = 7+5 = 12, num =0 => num = 12, sum = 0;
// 12
// sum = 2, num = 1;
// sum = 2+1 = 3, num =0 => return sum = 3
