// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/move-zeroes/

class Solution {
    // two pointer, i pointer start from 0
    // and j pointer iterate the array, if the cur is not zero
    // then we let nums[i] = nums[j]
    // by the end, the remain position are 0, then fill them
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                if (i != j) {
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
