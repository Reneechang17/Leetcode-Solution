// Easy
// Brute Force
// Time:O(n^3), Space:O(1)
// https://leetcode.cn/problems/count-good-triplets/

class Solution {
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
      int cnt = 0;
      for (int i = 0; i < arr.length - 2; i++) {
          int x = arr[i];
          for (int j = i + 1; j < arr.length - 1; j++) {
              int y = arr[j];
              for (int k = j + 1; k < arr.length; k++) {
                  int z = arr[k];
                  if (Math.abs(x - y) <= a && Math.abs(y - z) <= b && Math.abs(x - z) <= c) {
                      cnt++;
                  }
              }
          }
      }
      return cnt;
  }
}
