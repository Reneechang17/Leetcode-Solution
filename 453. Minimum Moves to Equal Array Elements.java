// Medium
// Math
// O(n): we iterate the array twice
// https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/

class Solution {
  // use min moves to make all the element's val are equal
  // every time we make n - 1's element + 1, that eventually let the biggest element close to the min element
  // so we can find the min element and calculate the dis between each element with min element
  // that will be the min moves we need 
  public int minMoves(int[] nums) {
      int minNum = Integer.MAX_VALUE;
      int moves = 0;

      for (int x : nums) {
          minNum = Math.min(minNum, x);
      }

      for (int x : nums) {
          moves += x - minNum;
      }
      return moves;
  }
}
