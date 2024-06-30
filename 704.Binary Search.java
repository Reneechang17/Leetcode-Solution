// Easy
// Array, Binary Search
// O(log n)
// https://leetcode.com/problems/binary-search/

class Solution {
  public int search(int[] nums, int target) {
    // Use binary search to find the mid
    int left = 0, right = nums.length;
    while (left < right) {
      int mid = left + ((right - left) >> 1);
      // if mid is target, we find the target
      if (nums[mid] == target)
        return mid;
      // if target at the right side
      else if (nums[mid] < target)
        // adjust the left edge
        left = mid + 1;
      else if (nums[mid] > target)
        // Otherwise, adjust the right edge
        right = mid;
    }
    // if target not exist, return -1
    return -1;
  }
}

/**
 * 思路：標準的二分查找
 * while循環條件為left < right時，持續尋找
 * 先計算初始化的mid位置
 *  如果mid就是要找的target，直接返回mid
 *  如果target大於mid，代表在右邊，更新left邊界
 *  如果target小於mid，代表在左邊，更新right邊界
 **/