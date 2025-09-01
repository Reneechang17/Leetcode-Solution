// Medium
// Matrix, Simulation
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/diagonal-traverse/

import java.util.*;

class Solution {
    /**
     * key point: row+col = k(k is diagonal no.)
     *
     * k=0: (0.0) = [1] -> going up
     * k=1: (0,1),(1,0) = [2,4] -> going down
     * k=2: (0,2),(1,1),(2,0) = [3,5,7] -> going up
     * k=3: (1,2),(2,1) = [6,8] -> going down
     * k=4: (2,2) = [9] -> going up
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int idx = 0;

        // iterate each diagonal
        for (int k = 0; k < m + n - 1; k++) {
            List<Integer> diagonal = new ArrayList<>();
            for (int row = 0; row < m; row++) {
                int col = k - row; // row+col=k
                if (col >= 0 && col < n) {
                    diagonal.add(mat[row][col]);
                }
            }
            // Decide direction 
            if (k % 2 == 0) {
                Collections.reverse(diagonal);
            }

            for (int val: diagonal) {
                res[idx++] = val;
            }
        }
        return res;
    }
}
