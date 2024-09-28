// Hard
// Binary Search, Greedy
// O(nlogS)
// https://leetcode.com/problems/split-array-largest-sum/

class Solution {
  public int splitArray(int[] nums, int k) {
      int left = 0, right = 0;

      for (int num : nums) {
          left = Math.max(left, num);
          right += num;
      }

      while (left < right) {
          int mid = (left + right) >> 1;

          if (canSplit(nums, k, mid)) {
              right = mid; // 如果可以就縮小範圍繼續找最小值
          } else {
              left = mid + 1; // 不能就要擴大範圍
          }
      }
      return left;
  }

  private boolean canSplit(int[] nums, int k, int maxSum) {
      int curSum = 0;
      int split = 1; // 至少需要一個子數組

      for (int num : nums) {
          if (curSum + num > maxSum) {
              split++;
              curSum = num;
              if (split > k) {
                  return false;
              }
          } else {
              curSum += num;
          }
      }
      return true;
  }
}

/**
 * 將數組分成k個子數組，使得這些子數組的和的最小值最小
 * 也就是說需要找到一種劃分方式可以使得k個子數組的和的最大值最小（有點繞口）
 * 
 * 思路：這題可以用二分結合貪心做，二分的左邊界就是數組中的最大值，因為最大和不會小於這個數組的最大值，右邊界就是數組的和（最壞情況下只有一個子數組就是這個數組的和）
 * 用二分來確定最大子數組和的候選值，通過遍歷數組來判斷是否可以把數組分成k個子數組，並計算這個子數組的和，一旦等於mid（maxSum）就把子數組數量加一，如果超過k就返回false
 **/