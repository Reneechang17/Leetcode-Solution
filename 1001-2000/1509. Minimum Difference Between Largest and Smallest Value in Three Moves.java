// Medium
// Array, Sorting
// O(N logN)
// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/

import java.util.Arrays;

class Solution {
  public int minDifference(int[] nums) {
      if (nums.length <= 4) return 0;

      Arrays.sort(nums);
      int n = nums.length;

      int minDiff = Integer.MAX_VALUE;
      minDiff = Math.min(minDiff, nums[n - 4] - nums[0]);
      minDiff = Math.min(minDiff, nums[n - 3] - nums[1]);
      minDiff = Math.min(minDiff, nums[n - 2] - nums[2]);
      minDiff = Math.min(minDiff, nums[n - 1] - nums[3]);
      return minDiff;
  }
}

/**
 * 目標是在一個整數數組中修改最多三個元素，使得數組元素的差的最大值最小化
 * 
 * 首先可以看出一個basecase：如果數組的元素小於4，可以直接返回0
 * 因為最多可以改3個，如果數組元素只有0123個，可以將所有元素改成同一個數，這樣差就是0
 * 如果有4個元素的話，可以將任意三個元素改成和第四個元素同一個元素，相減為0
 * 
 * 如果數組元素大於4，可以先將數組排序，考慮改變數組的前三個和最後三個元素的組合，計算這些操作後數組的最大和最小值
 * 1. 只改變最後面三個元素：計算第一個元素和倒數第四個元素之間的差
 * 2. 改變最前面一個元素，和最後面兩個元素：從第二個元素開始計算，將其與倒數第三個元素作比較（改變了最後兩個元素，意味著倒數第三個元素可能是新的最大值）
 * 3. 改變最前面兩個元素，和最後面一個元素：從第三個元素開始計算，最後一個元素也改變，比較第三個元素和倒數第二個元素
 * 4. 只改變最前面三個元素：此時第四個元素可能是最小值了
 **/