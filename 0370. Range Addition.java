// Medium
// Difference Array
// Time:O(m+n), Space:O(n)
// https://leetcode.cn/problems/range-addition/

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];

        for (int[] u : updates) {
            int start = u[0], end = u[1], val = u[2];

            diff[start] += val;
            if (end + 1 < length) {
                diff[end + 1] -= val;
            }
        }

        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
