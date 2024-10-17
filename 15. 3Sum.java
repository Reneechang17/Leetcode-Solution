// Medium
// Two Pointers, Sorting
// O(n^2)
// https://leetcode.cn/problems/3sum/

import java.util.*;

class Solution {
  // 可以用雙指針+排序，首先將數組排序，如果第一個元素大於0的話可以直接返回
  // 三個指針分別指向i = 0， left = i + 1， right = nums.length - 1
  public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);
      
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] > 0) {
              return res;
          }

          // 對i去重
          if (i > 0 && nums[i] == nums[i - 1]) continue;

          int left = i + 1, right = nums.length - 1;
          while (left < right) {
              int sum = nums[i] + nums[left] + nums[right];
              if (sum > 0) {
                  right--; // 用小一點的數字
              } else if (sum < 0) {
                  left++; // 用大一點的數字
              } else {
                  res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                  // 對左右指針去重
                  while (left < right && nums[right] == nums[right - 1]) {
                      right--;
                  }
                  while (left < right && nums[left] == nums[left + 1]) {
                      left++;
                  }
                  right--;
                  left++;
              }
          }
      }
      return res;
  }
}

/**
 * 思路：雙指針+排序
 * 1. 先將整個數組進行排序
 * Note: 如果排序後第一個元素已經大於0，可以直接返回（因為都是正整數湊不出0）
 * 2. 定義三個指針：i=> 下標0開始，left=> i+1開始，right=> 數組結尾開始
 * 3. 依舊是找a+b+c等於0，相當於a = nums[i]，b = nums[left]，c = nums[right]
 * 4. 如果nums[i] + nums[left] + nums[right] > 0，說明三數之和大了，此時right--，讓sum小一點
 *    同理，如果nums[i] + nums[left] + nums[right] < 0，說明三數之和小了，left++，讓sum大一點
 * 5. 當sum = 0 時，加入res中，直到左右指針相遇（left>right)
 * Note: 當找到三數之和為0時，我們需要對左右指針做去重！i也要去重（用nums[i]和nums[i - 1]比
 **/
