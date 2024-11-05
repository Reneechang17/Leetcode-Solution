// Medium
// Array, Greedy
// O(n)
// https://leetcode.cn/problems/jump-game/

class Solution {
    // our goal is jump to the last position
    // we can hold a variable to record the most far position we can reached in current
    public boolean canJump(int[] nums) {
        int farPos = 0;

        // go through the nums, and check each i
        for (int i = 0; i < nums.length; i++) {
            // if the current position is bigger than the most far pos
            // means we can not jump
            if (i > farPos) {
                return false;
            }

            // or we update the farthest pos
            // means the fartheast pos we can reached from cur pos
            farPos = Math.max(farPos, i + nums[i]);

            if (farPos >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
