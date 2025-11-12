// Medium
// Matrix, HashSet
// Time:O(m*n * min(m,n)),Space:O(m*n)
// https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals/

import java.util.*;

class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> topLeft = new HashSet<>();
                Set<Integer> bottomRight = new HashSet<>();
                // ↖
                for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
                    topLeft.add(grid[x][y]);
                }
                // ↘
                for (int x = i + 1, y = j + 1; x < m && y < n; x++, y++) {
                    bottomRight.add(grid[x][y]);
                }
                res[i][j] = Math.abs(topLeft.size() - bottomRight.size());
            }
        }
        return res;
    }
}
