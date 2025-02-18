// Hard
// MergeSort
// Time:O(nlogn),Stack:O(n)
// https://leetcode.cn/problems/reverse-pairs/

class Solution {
  // 拆分数组，对左右两部分分别计数
  // 在合并时统计逆序对:对左半部分left的每个nums[i],查找右半部分right满足 
  // nums[i]>2*nums[j]的nums[j]数量。合并左右部分，保证排序性
  // 递归处理，最终统计所有逆序对
  public int reversePairs(int[] nums) {
      if (nums.length < 2) return 0;
      return mergeSort(nums, 0, nums.length - 1);
  }
  private int mergeSort(int[] nums, int left, int right) {
      if (left >= right) return 0;
      int mid = left + (right - left) / 2;
      int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

      // 统计逆序对
      int j = mid + 1;
      for (int i = left; i <= mid; i++) {
          while (j <= right && nums[i] > 2L * nums[j]) {
              j++;
          }
          count += j - (mid + 1);
      }
      // 归并
      merge(nums, left, mid, right);
      return count;
  }
  private void merge(int[] nums, int left, int mid, int right) {
      int[] temp = new int[right - left + 1];
      int i = left, j = mid + 1, k = 0;
      while (i <= mid && j <= right) {
          if (nums[i] <= nums[j]) {
              temp[k++] = nums[i++];
          } else {
              temp[k++] = nums[j++];
          }
      }
      while (i <= mid) temp[k++] = nums[i++];
      while (j <= right) temp[k++] = nums[j++];
      System.arraycopy(temp, 0, nums, left, temp.length);
  }
}
