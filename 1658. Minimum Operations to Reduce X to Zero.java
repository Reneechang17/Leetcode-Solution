// Medium
// Array, Sliding Window
// O(n)

class Solution {
  public int minOperations(int[] nums, int x) {
      // calculate the total sum of nums
      int numsSum = 0;
      for(int num : nums){
          numsSum += num;
      }
      // the target sum of what we find(the max subarray) is numsSum - x
      int target = numsSum - x;
      // handle edge case
      if(target < 0) return -1;
      if (target == 0)
        return nums.length;
      
      // find the max sub array which sum is target 
      int maxLen = -1;
      int sum = 0;
      int left = 0;

      for(int right = 0; right < nums.length; right++){
          sum += nums[right];
          while (sum > target && left < right){
              sum -= nums[left];
              left++;
          }
          if(sum == target){
              maxLen = Math.max(maxLen, right - left + 1);
          }
      }
      if(maxLen == -1) return -1;
      return nums.length - maxLen;

  }
}