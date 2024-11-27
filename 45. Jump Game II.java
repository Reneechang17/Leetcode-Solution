// Medium
// Greedy
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/jump-game-ii/

class Solution {
    // we can always jump to the farthest reachable position at each step
    // Track the cur range and the next max range, update the jump count whenever reach the end of the cur range
    public int jump(int[] nums) {
        // basecase
        if (nums.length == 1 || nums.length == 0 || nums == null) return 0;
        int count = 0, curMaxRange = 0, maxRange = 0;
        
        // iterate nums, calculate the fartheast pos we can reached
        for (int i = 0; i < nums.length; i++) {
            // update the maxRange we can reached for next jump
            maxRange = Math.max(maxRange, i + nums[i]);
            // check if the next jump can jump to the end 
            if (maxRange >= nums.length - 1) {
                count++;
                break;
            } 
            // if the cur i is reached the fartheast pos, update the curMaxRange with maxRange
            if (i == curMaxRange) {
                curMaxRange = maxRange;
                count++;
            }
        }
        return count;
    }
}
