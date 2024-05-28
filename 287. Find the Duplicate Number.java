// Medium
// Array, Binary Search
// O(n logn)

class Solution {
  public int findDuplicate(int[] nums) {
      int left = 0, right = nums.length - 1;
      while(left < right){
          int mid = (left + right) >> 1;
          int cnt = 0;
          for(int num : nums){
              if(num <= mid){
                  cnt++;
              }
          }
          if(cnt > mid){
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }
}
