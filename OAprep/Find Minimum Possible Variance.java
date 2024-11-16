package OAprep;

// we can go through each element as the start height
// and then go through the rest of the elements to find the same height
// calculate the possible variance, and update the res

class Solution {
  public int findMinimumVariance(int[] height) {
    // write your code here
    int n = height.length;
    int res = Integer.MAX_VALUE;
  
    for (int start = 0; start < n; start++) {
      int targetHeight = height[start];
      int cnt = 0;
  
      for (int end = start; end < n; end++) {
        if (height[end] == targetHeight) {
          cnt++;
  
          if (end - start + 1 > 2) {
            int variance = (end - start + 1) - cnt;
            res = Math.min(res, variance);
          }
        }
      }
    }
    return res;
  }
}
