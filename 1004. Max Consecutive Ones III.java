// Medium
// Sliding Window
// O(n)
// https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
  public int longestOnes(int[] nums, int k) {
      int left = 0, right = 0;
      int maxLength = 0;
      int zero = 0;
      int n = nums.length;

      while (right < n) {
          if (nums[right] == 0) {
              zero++;
          }

          while (zero > k) {
              if (nums[left] == 0) {
                  zero--;
              }
              left++;
          }
          maxLength = Math.max(maxLength, right - left + 1);
          right++;
      }
      return maxLength;
  }
}

/**
 * 最大連續1的個數III：給定一個數組由0和1組成，最多可以改變k個0，找包含最多1的連續子數組
 * 
 * 這題其實沒有什麼技巧，可以直接用滑動窗口來解：維護一個滑動窗口，保證窗口中的0的個數不超過k個
 * 初始化左右指針都從0出發，先不斷向右擴展，遇到0則zero的個數++
 * 當zero的個數超過k時，開始縮小窗口，挪動左指針
 * 與此同時，不斷更新最長的長度，最後直接返回最長長度即可
 **/