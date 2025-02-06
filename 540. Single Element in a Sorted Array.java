// Medium
// Binary search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/single-element-in-a-sorted-array/

class Solution {
  // Use mid ^ 1 to check if mid is paired correctly
  // If nums[mid] == nums[mid ^ 1] -> left = mid + 1
  // Otherwise -> right = mid
  public int singleNonDuplicate(int[] nums) {
      int left = 0, right = nums.length - 1;
      while (left < right) {
          int mid = (left + right) >> 1;
          if (nums[mid] == nums[mid ^ 1]) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      return nums[left];
  }
}

// 要求用logn，可以想到二分查找。可以优先观察规律：可以发现成对的索引0,1 2,3（即偶数索引i和i+1）
// 可以发现单独元素的左侧部分是正常成对的，右侧部分是错位的
// 如果nums[mid]==nums[min^1](^是异或运算，相当于mid是否为偶数)，说明mid之前的部分是成对的
// 那么单独元素在右半部(left = mid + 1)，否则在左半部分
