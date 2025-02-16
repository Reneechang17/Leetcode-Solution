// Easy
// Array
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/

class Solution {
  public int[] replaceElements(int[] arr) {
      int n = arr.length;
      int[] res = new int[n];
      res[n - 1] = -1;
      for (int i = n - 2; i >= 0; i--) {
          res[i] = Math.max(res[i + 1], arr[i + 1]);
      }
      return res;
  }
}
