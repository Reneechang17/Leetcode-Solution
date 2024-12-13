// Easy
// Math, String
// Time:O(max(m,n)), Space:O(max(m,n))
// https://leetcode.cn/problems/add-binary/

class Solution {
  // Use two pointers start from the end of both strings to simulate binary addition
  // Add digits along with the carry and append the res to a StringBuilder
  // Reverse the StringBuilder at the end to get the current result
  public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int carry = 0;
      int i = a.length() - 1, j = b.length() - 1;
      while (i >= 0 || j >= 0 || carry != 0) {
          int sum = carry;
          if (i >= 0) sum += a.charAt(i--) - '0';
          if (j >= 0) sum += b.charAt(j--) - '0';
          sb.append(sum % 2); // add the binary digit(0 or 1)
          carry = sum / 2; // update the carry
      }
      return sb.reverse().toString();
  }
}
