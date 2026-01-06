// Medium
// String
// Time:O(m*n),Space:O(m+n)
// https://leetcode.cn/problems/multiply-strings/

class Solution {
  public String multiply(String num1, String num2) {
      int n1 = num1.length(), n2 = num2.length();
      int[] res = new int[n1 + n2];

      for (int i = n1 - 1; i >= 0; i--) {
          for (int j = n2 - 1; j >= 0; j--) {
              int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
              // confirm the storage index
              int p1 = i + j, p2 = i + j + 1;
              int sum = mul + res[p2]; // exist val plus new product
              res[p2] = sum % 10;
              res[p1] += sum / 10;
          }
      }
      StringBuilder sb = new StringBuilder();
      for (int num : res) {
          if (!(sb.length() == 0 && num == 0)) {
              sb.append(num);
          }
      }
      return sb.length() == 0 ? "0" : sb.toString();
  }
}