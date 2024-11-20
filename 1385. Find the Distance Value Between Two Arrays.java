// Easy
// Array, Simulation
// Time: O(mn), Space: O(1) 
// https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/

class Solution {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
      int count = arr1.length;
      for (int a : arr1) {
          for (int b : arr2) {
              if (Math.abs(a - b) <= d) {
                  count--;
                  break;
              }
          }
      }
      return count;
  }
}
