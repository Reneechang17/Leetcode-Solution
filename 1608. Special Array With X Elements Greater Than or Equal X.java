import java.util.Arrays;

// Easy
// Array, Binary Search, Sorting
// O(n * logn)

class Solution {
  public int specialArray(int[] nums) {
      Arrays.sort(nums);
      int len = nums.length;
      for(int x = 1; x <= len; ++x){
          int left = 0, right = len;
          while(left < right){
              int mid = (left + right) >> 1;
              //往左邊查
              if(nums[mid] >= x){
                  right = mid;
              } else {
                  left = mid + 1;
              }
          }
          int cnt = len - left;
          if(cnt == x){
              return x;
          }
      }
      return -1;
  }
}