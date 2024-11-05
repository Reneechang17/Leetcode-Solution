// Medium
// Greedy
// O(n)
// https://leetcode.cn/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {
        // basecase
        if (nums.length == 1 || nums.length == 0 || nums == null) return 0;
        
        int count = 0, curMaxRange = 0, maxRange = 0;

        // go through the nums, for each i, we need to calculate the fartheast position we can reached
        for (int i = 0; i < nums.length; i++) {
            // and update the maxRange we can reached
            maxRange = Math.max(maxRange, i + nums[i]);

            if (maxRange >= nums.length - 1) {
                count++;
                break;
            }

            // if the cur i is reached the farthest position we reached, then we update the curMaxRange to maxRange
            if (i == curMaxRange) {
                curMaxRange = maxRange;
                count++;
            }
        }
        return count;
    }
}
