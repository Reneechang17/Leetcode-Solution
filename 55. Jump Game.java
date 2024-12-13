// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/jump-game/

class Solution {
    // Use Greedy idea to maintain a variable, which record the farthest pos from cur
    // If cur pos is bigger than the farthest pos, we cannot jump to end
    // If we can jump to this pos(i<=far), update the farthest
    public boolean canJump(int[] nums) {
        int farPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farPos) return false;
            farPos = Math.max(farPos, i + nums[i]);
            if (farPos >= nums.length - 1) return true;
        }
        return false;
    }
}
