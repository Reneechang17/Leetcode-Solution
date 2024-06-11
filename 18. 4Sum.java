// Medium
// Array, Two Pointers, Sorting
// O(n log n)
// n is the length of nums
// https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);

      for(int i = 0; i < nums.length; i++){
          if(nums[i] > 0 && nums[i] > target) return res;
          if(i > 0 && nums[i] == nums[i - 1]) continue;

          for(int j = i + 1; j < nums.length; j++){
              if(j > i + 1 && nums[j] == nums[j - 1]) continue;

              int left = j + 1, right = nums.length - 1;
              while(left < right){
                  long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                  if(sum > target) {
                      right--;
                  } else if(sum < target) {
                      left++;
                  } else {
                      res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                      while(right > left && nums[right] == nums[right - 1]) right--;
                      while(right > left && nums[left] == nums[left + 1]) left++;

                      left++;
                      right--;
                  }
              }
          }
      }
      return res;
  }
}

/**
 * 思路：雙指針+排序
 *      在3Sum的基礎上在嵌套一個j的for循環，j的初始為i+1
 * 1. 先將整個數組進行排序
 * 2. 最外層for循環i，i從0開始
 * Note：先處理a. 如果nums[i]已經大於target，後面就湊不到了，直接return res
 *            b. 對i指針去重(nums[i] compare with nums[i - 1])
 * 3. 嵌套for循環j，j從i+1開始
 * Note：對j指針去重(j > i + 1 && nums[j] == nums[j - 1])
 * 4. 在第二層for循環內加入left和right指針，通過sum和target比較來調整left和right
 **/