// Easy
// Array
// Time: O(n), Space: O(1) -> Iterate the array
// followup: O(logn) -> binary search
// https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/

class Solution {
  public int maximumCount(int[] nums) {
      int pos = 0, neg = 0;

      for (int x : nums) {
          if (x > 0) {
              pos++;
          } else if (x < 0) {
              neg++;
          }
      }
      return Math.max(pos, neg);
  }
}

// followup: if we need to implement the O(logn) algorithm
// we can use binary search to find the first non-neg index and first pos index
class Solution2 {
  public int maximumCount(int[] nums) {
      int firstNonNeg = findFirst(nums, 0);
      int firstPos = findFirst(nums, 1);

      int negCount = firstNonNeg;
      int posCount = nums.length - firstPos;
      return Math.max(negCount, posCount);
  }

  private int findFirst(int[] nums, int target) {
      int left = 0, right = nums.length - 1;
      while (left <= right) {
          int mid = (left + right) >> 1;
          if (nums[mid] < target) {
              left = mid + 1;
          } else {
              right = mid - 1;
          }
      }
      return left; // the left will be first >= target
  }
}
