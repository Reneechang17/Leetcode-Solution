// Easy
// Binary Search
// O(log n)
// https://leetcode.com/problems/binary-search/

class Solution {
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length;

    while (left < right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target)
        return mid;
      else if (nums[mid] < target)
        left = mid + 1;
      else if (nums[mid] > target)
        right = mid;
    }
    return -1;
  }
}

/**
 * 思路：標準的二分查找
 * while循環條件為left < right時，持續尋找
 * 先計算初始化的mid位置
 * 如果mid就是要找的target，直接返回mid
 * 如果target大於mid，代表在右邊，更新left邊界
 * 如果target小於mid，代表在左邊，更新right邊界
 **/