// Medium
// Binary Search
// O(logn)
// Similar: 410
// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
  public int shipWithinDays(int[] weights, int days) {
      int left = 0, right = 0;

      for (int w : weights) {
          left = Math.max(left, w);
          right += w;
      }

      while (left < right) {
          int mid = (left + right) >> 1;

          if (canShip(weights, days, mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }

  private boolean canShip (int[] weights, int days, int maxW) {
      int curW = 0, curD = 1;
      for (int w : weights) {
          if (curW + w > maxW) {
              curD++;
                  curW = w;
              if (curD > days) {
                  return false;
              }
          } else {
              curW += w;
          }
      }
      return true;
  } 
}

/**
 * 解法類似410，這題是要找到一個最小值，使得在D天內運完所有包裹
 **/