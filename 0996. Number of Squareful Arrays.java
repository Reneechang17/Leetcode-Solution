// Hard
// Backtracking, Pruning
// Time:O(n^2), Space:O(n!)
// https://leetcode.cn/problems/number-of-squareful-arrays/

import java.util.Arrays;

class Solution {
    // Use backtracking, but brute force will exceed runtime
    // Optimization: precompute the Pair to check if nums[i]&nums[j] is perfect square
    // Apply pruning: 1.skip used num, 2.avoid duplicate with sorting and check prev
    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        boolean[][] canPair = new boolean[n][n];

        // precompute the neighbor pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                if (isPerfectSquare(sum)) {
                    canPair[i][j] = canPair[j][i] = true;
                }
            }
        }

        boolean[] vis = new boolean[n];
        return backtracking(nums, canPair, vis, -1, 0, n);
    }
    
    private int backtracking(int[] nums, boolean[][] canPair, boolean[] vis, int prev, int cnt, int n) {
        if (cnt == n) return 1; // valid permutation
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) continue; // skip duplicate

            // only first char and the char can pair with prev can enter 
            if (prev == -1 || canPair[prev][i]) {
                vis[i] = true;
                total += backtracking(nums, canPair, vis, i, cnt + 1, n);
                vis[i] = false;
            }
        }
        return total;
    }

    private boolean isPerfectSquare(int num) {
        int square = (int)Math.sqrt(num);
        return square * square == num;
    }
}
