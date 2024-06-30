// Medium
// Array, Sliding Window
// O(n)
//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

class Solution {
  public int minOperations(int[] nums, int x) {
      int numsSum = 0;
      for (int num : nums) {
          numsSum += num;
      }
      
      int target = numsSum - x;

      // base case
      if(target < 0) return -1;
      if (target == 0)
        return nums.length;
      
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

/**
 * 這題是通過從數組的最右側 or 最左側刪除元素來縮小x的值，目標是把x減到0，要返回實現這個目標的最小操作次數，如果不能就返回-1
 * 先排除base case：如果target小於0直接返回-1，或是target = 0，直接返回數組的長度（不需操作就是0次操作）
 * 
 * 可以轉換思路：這題相當於找數組的totalSum-x的最大子數組
 * -> 可以先計算數組的totalSum，然後將他減去x就是我們滑動窗口找的target
 * 
 * 使用左右指針來操作滑動窗口，右指針擴大窗口，將每次遍歷的元素加入sum中更新
 * 當sum已經超過target（並且左指針還沒超過右指針時），移動左指針來縮小窗口，並且更新窗口的sum（減去left遍歷到的）
 * 
 * 當sum是我們要找的target時，就計算他的長度，並且和前一個maxLen取大更新
 * 
 * 最後用數組長度減去最大的子數組就是我們需要刪除的元素數量（操作次數）
 * Note：因為是滑動窗口，我們要刪除的是窗口外的所有元素，可以從左or右側進行刪除
 **/