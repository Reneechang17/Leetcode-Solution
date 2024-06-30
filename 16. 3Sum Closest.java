// Medium
// Array, Two Pointers, Sorting
// O(n^2)
// https://leetcode.com/problems/3sum-closest/

import java.util.Arrays;

class Solution {
  public int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int ans = Integer.MAX_VALUE;

      for(int i = 0; i < nums.length; i++){
          int left = i + 1, right = nums.length - 1;
          while(left < right){
              int sum = nums[i] + nums[left] + nums[right];
              if(sum == target){
                  return sum;
              }
              if(Math.abs(sum - target) < Math.abs(ans - target)){
                  ans = sum;
              }
              if(sum > target){
                  right--;
              } else {
                  left++;
              }
          }
      }
      return ans;
  }
}

/**
 * 思路：雙指針+排序，和15. 3Sum差不多
 * 1. 先將整個數組進行排序
 * 2. 也是定義三個指針：i=> 下標0開始，left=> i+1開始，right=> 數組結尾開始，依舊找a+b+c(sum)
 * 3. 當sum等於target時，直接返回target
 * 4. 不然就找較小值，用絕對值是因為，要找的是較近的距離，而非具體的正負
 * 5. 正常通過sum調整right 和 left
 **/