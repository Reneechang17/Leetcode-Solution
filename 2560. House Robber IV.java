// Medium
// Array, Binary Search
// O(log(max(nums) - min(nums)) * n)
// https://leetcode.com/problems/house-robber-iv/

class Solution {
  public int minCapability(int[] nums, int k) {
    int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

    // 確定二分的上下界
    for (int num : nums) {
      left = Math.min(left, num);
      right = Math.max(right, num);
    }

    // 二分
    while (left < right) {
      int mid = (left + right) >> 1;

      // 驗證是否可以在不超過mid的情況下找到k個不相鄰的房子
      if (canRob(nums, mid, k)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
  
  // 是否能在不超過mid的情況下搶劫k個不相鄰的房子
  private boolean canRob(int[] nums, int capability, int k) {
      int count = 0; // 紀錄房子的數量
      int n = nums.length;
      for (int i = 0; i < n; i++) {
          if (nums[i] <= capability) {
              count++;
              i++; // 需要跳過下一個房子（相鄰不能搶）
          }
          if (count >= k) {
              return true;
          }
      }
      return false;
  }
}

/**
 * 搶劫房子IV：有一排n個房子，每個房子中有一定數量的錢，不能搶劫相鄰的房子，求在不超過capability的情況下，最少能搶劫多少錢
 * 
 * 思路：常理來想會想到Dp之類的解法，但是這題有一個point是在約束條件下找min-max，這種情況下二分查找比較高效，它可以在一個連續範圍內快速縮小搜索範圍
 * 使用二分需要先找到上下界，用Math中的min和max可以找到
 * 然後在二分查找的過程中，每次驗證是否能在不超過mid的情況下找到k個不相鄰的房子
 * 這裡需要一個helper function去驗證，注意因為不能搶相鄰的房子，每次計數的房子+1時，需要跳過下一個房子（i++）
 **/