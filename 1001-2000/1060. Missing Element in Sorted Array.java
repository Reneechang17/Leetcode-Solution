// Medium
// Binary search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/missing-element-in-sorted-array/

class Solution {
  // Calculate total missing numbers: missing(n-1)=nums[n-1]-nums[0]-(n-1)
  // If missing(n-1) < k, return nums[n-1]+(k-missing(n-1))
  // Use binary search to find the first nums[i] where missing(i) >= k
  // Compute missing value: nums[left-1] + (k - missing(left-1))
  public int missingElement(int[] nums, int k) {
      int n = nums.length;
      int missing = nums[n - 1] - nums[0] - (n - 1);
      
      // if missing num out of nums' range
      if (missing < k) {
          return nums[n - 1] + (k - missing);
      }

      int left = 0, right = n - 1;
      while (left < right) {
          int mid = (left + right) >> 1;
          // calculate the missing num before nums[mid]
          int missingMid = nums[mid] - nums[0] - mid;
          if (missingMid < k) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      return nums[left - 1] + (k - (nums[left - 1] - nums[0] - (left - 1)));
  }
}

// 首先nums[i]-nums[0]是理论上应有的元素数量，i计算数组中实际存在的元素数量
// missing(i)=nums[i]-nums[0]-i就是nums[i]之前丢失的元素个数
// 如果missing(n-1)<k，表示第k个缺失的元素在nums范围之外，
//   - 返回nums[n-1]+(k-missing(n-1)) -> example3情况
// 如果missing(mid) < k，表示第k个缺失数在右侧 -> left = mid + 1，否则在右侧
