// Hard
// Binary Search
// O(logn)
// Similar: 410
// https://leetcode.com/problems/divide-chocolate/

class Solution {
  public int maximizeSweetness(int[] sweetness, int k) {
      int left = 0, right = 0;
      for (int s : sweetness) {
          right += s;
      }
      
      // 二分sweetness的總和
      while (left < right) {
          int mid = (left + right + 1) >> 1; // 向上取整
          if (check(sweetness, mid, k)) {
              left = mid;
          } else {
              right = mid - 1;
          }
      }
      return left;
  }

  private boolean check (int[] sweetness, int mid, int k) {
      int sum = 0, count = 0;
      for (int s : sweetness) {
          sum += s;
          if (sum >= mid) {
              sum = 0;
              count++;
          }
      }
      return count > k;
  }
}
