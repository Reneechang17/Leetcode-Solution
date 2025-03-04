// Medium
// Matrix, Simulation
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/diagonal-traverse/

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if(mat == null || mat.length == 0 || mat[0].length == 0) return new int[0];
        int m = mat.length, n = mat[0].length, index = 0;
        int[] res = new int[m * n];

        for (int d = 0; d < m + n - 1; d++) {
            // start from mat[0,d] or mat[d,0]
            int row = d < m ? d : m - 1;
            int col = d < m ? 0 : d - m + 1;

            List<Integer> curDiagonal = new ArrayList<>();
            while (row >= 0 && col < n) {
                curDiagonal.add(mat[row][col]);
                row--;
                col++;
            }
            // fill res arr
            if (d % 2 == 0) {
                for (int x : curDiagonal) {
                    res[index++] = x;
                }
            } else {
                // reverse iterate
                for (int i = curDiagonal.size() - 1; i >= 0; i--) {
                    res[index++] = curDiagonal.get(i);
                }
            }
        }
        return res;
    }
}
