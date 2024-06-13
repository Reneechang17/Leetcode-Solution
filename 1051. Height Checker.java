// Easy
// Array, Sorting
// O(n)
// https://leetcode.com/problems/height-checker/

import java.util.Arrays;
class Solution {
  public int heightChecker(int[] heights) {
      // int[] expected = heights.clone();
      int[] expected = new int[heights.length];
      System.arraycopy(heights, 0, expected, 0, heights.length);
      // System.out.println(Arrays.toString(expected));
      Arrays.sort(expected);
      int ans = 0;
      for(int i = 0; i < heights.length; ++i){
          if(heights[i] != expected[i]){
              ++ans;
          }
      }
      return ans;
  }
}

/**
 * 這題是要找有幾個位置和sorting後的不一樣
 * 思路：
 * 直接clone一個數組 => 可以直接用clone這個method或是用arraycopy
 * 然後把克隆的數組進行排序，遍歷原數組，檢查原數組和正確排序後的有幾個元素不一樣
 **/