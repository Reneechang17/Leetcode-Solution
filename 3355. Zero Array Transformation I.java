// Medium
// Array
// Time:O(n+m),Space:O(n)
// https://leetcode.cn/problems/zero-array-transformation-i/

class Solution {
    // 差分数组，没学过，直接抄了，今天太累以后再说吧
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[] cmp = new int[n + 1];

        // 差分数组：查询的左端点数组下标+1，右端点对应的数组下标后一位-1
        for (int i = 0; i < m; i++) {
            cmp[queries[i][0]]++;
            cmp[queries[i][1] + 1]--;
        }

        // 差分数组求前缀和，得到每个下标最大影响数
        for (int i = 1; i < n; i++) {
            cmp[i] += cmp[i - 1];
        }

        // cmp数组与nums数组比较，如果值都大于等于，true，否则false
        for (int i = 0; i < n; i++) {
            if (cmp[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
