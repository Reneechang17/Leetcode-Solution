// Easy
// DP, Backtracking, XOR
// Time:O(2^n),Space:O(n)
// https://leetcode.cn/problems/sum-of-all-subset-xor-totals/

class Solution {
    private int res, n;
    
    public int subsetXORSum(int[] nums) {
        res = 0;
        n = nums.length;
        dfs(0, 0, nums);
        return res;
    }

    private void dfs(int val, int index, int[] nums) {
        if (index == n) {
            res += val;
            return;
        }
        // choose cur 
        dfs(val ^ nums[index], index + 1, nums);
        // not choose cur
        dfs(val, index + 1, nums);
    }
}
