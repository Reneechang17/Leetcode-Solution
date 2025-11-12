// Hard
// Backtracking
// Time:O(4^(m*n)), Space:O(m*n)
// https://leetcode.cn/problems/unique-paths-iii/

class Solution {
    private static final int[][] DIRS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private int rows, cols;
    private int path = 0;
    private int empty = 0;

    public int uniquePathsIII(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;

        int startRow = -1, startCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 2) {
                    empty++;
                }
            }
        }

        // start also calculate 1
        empty++;

        backtracking(grid, startRow, startCol, 1);
        return path;
    }

    private void backtracking(int[][] grid, int row, int col, int vis) {
        if (grid[row][col] == 2) {
            if (vis == empty) {
                path++;
            }
            return;
        }

        int tmp = grid[row][col];
        grid[row][col] = -2; // mark as vis

        for (int[] d : DIRS) {
            int nr = row + d[0], nc = col + d[1];

            if (isValid(grid, nr, nc)) {
                backtracking(grid, row, col, vis + 1);
            }
        }

        grid[row][col] = tmp;
    }

    private boolean isValid(int[][] grid, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return false;
        }
        return grid[r][c] == 0 || grid[r][c] == 2;
    }
}
