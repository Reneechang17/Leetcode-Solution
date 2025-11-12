// Hard
// Math, Recursion
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/permutation-sequence/ 

import java.util.*;

class Solution {
  // Use list to store the available numbers
  // Calculate (n-1)! to find the range of each digit
  // Determine each digit based on k and reduce the problem size
  public String getPermutation(int n, int k) {
      List<Integer> nums = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
          nums.add(i);
      }

      // calculate (n-1)!
      int fact = 1;
      for (int i = 1; i < n; i++) {
          fact *= i;
      }
      
      // minus 1, since k start from 1, and we use 0-based index
      k--; 

      StringBuilder sb = new StringBuilder();
      for (int i = n; i > 0; i--) {
          int index = k / fact;
          sb.append(nums.get(index));
          nums.remove(index);

          // update k
          k %= fact;
          if (i > 1) {
              fact /= (i - 1);
          }
      }
      return sb.toString();
  }
}
