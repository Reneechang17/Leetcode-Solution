import java.util.Arrays;

// Easy
// Array, Sorting
// O(n)

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
