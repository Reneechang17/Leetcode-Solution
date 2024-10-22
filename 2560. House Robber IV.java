// Medium
// Binary Search
// O(log(max - min) * n)
// https://leetcode.cn/problems/house-robber-iv/

class Solution {
  // 不能搶相鄰的房子，求在不超過capability下，最少可以搶到多少房子
  // 可能會想到DP，但是這裡有強調min，也就是可以看成一個min-max問題 -> 二分
  // 左右邊界可以用Math的min/max做到，helper去驗證是否可以在不超過mid的情況下搶劫k個不相鄰的房子
  public int minCapability(int[] nums, int k) {
      int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

      for (int num : nums) {
          left = Math.min(left, num);
          right = Math.max(right, num);
      }

      while (left < right) {
          int mid = (left + right) >> 1;
          // helper驗證是否可以在不超過mid的情況下搶劫k個不相鄰的房子
          if (canRob(nums, mid, k)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }

  private boolean canRob(int[] nums, int capability, int k) {
      int count = 0; // 紀錄可以偷的house的數量
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] <= capability) {
              count++;
              i++; // 需要跳過下一個房子，因為相鄰的房子不能搶
          }

          if (count >= k) {
              return true;
          }
      }
      return false;
  }
}
