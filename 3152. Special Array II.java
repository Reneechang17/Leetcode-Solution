// Medium
// Prefix
// Time:O(n+q),Space:O(n)
// https://leetcode.cn/problems/special-array-ii/

// Pretty interesting!

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // Use prefixSum to pre-handle
        int n = nums.length;
        int[] maxLen = new int[n];

        maxLen[n - 1] = 1; // last element can only give 1
        for (int i = n - 2; i >= 0; i--) {
            if ((nums[i] % 2) != (nums[i + 1] % 2)) {
                maxLen[i] = maxLen[i + 1] + 1;
            } else {
                maxLen[i] = 1; // if cannot extend -> just give 1
            }
        }

        boolean[] res = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0], to = queries[i][1];
            int requiredLen = to - from + 1;

            res[i] = (maxLen[from] >= requiredLen);
        }
        return res;
    }
}
