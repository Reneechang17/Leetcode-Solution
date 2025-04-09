// Easy
// Array
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/

class Solution {
  public int[] replaceElements(int[] arr) {
      int n = arr.length, max = -1;
      for (int i = n - 1; i >= 0; i--) {
          int curVal = arr[i];
          arr[i] = max;
          max = Math.max(max, curVal);
      }
      return arr;
  }
}
