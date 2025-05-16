// Medium
// Two Pointers
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/rearrange-array-elements-by-sign/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int posIndex = 0, negIndex = 1;

        for (int x : nums) {
            if (x > 0) {
                res[posIndex] = x;
                posIndex += 2;
            } else {
                res[negIndex] = x;
                negIndex += 2;
            }
        }
        return res;
    }
}
