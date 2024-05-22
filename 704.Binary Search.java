// Easy
// Array, Binary Search
// O(log n)

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