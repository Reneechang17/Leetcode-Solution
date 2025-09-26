// Medium
// Two Pointers
// Time:O(n^2), Space:O(1)
// https://leetcode.cn/problems/valid-triangle-number/

import java.util.*;

// a+b>c a<=b<=c

class Solution {
    public int triangleNumber(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        
        for (int k = nums.length - 1; k >= 2; k--) {
            int left = 0, right = k - 1;

            while (left < right) {
                if (nums[left] + nums[right] > nums[k]) {
                    // [left+1...right-1]+right are fine
                    cnt += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return cnt;
    }
}
