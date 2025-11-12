// Medium
// DFS
// Time:O(m*n), Space:O(m*n), call stack
// https://leetcode.cn/problems/number-of-islands/

class Solution {
    // iterate each pos, if cur is 1, then we dfs it
    // dfs to check the four directions of the cur pos
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int num = 0, rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    private void dfs(char[][] grid, int i, int j) {
        // validate the cur pos
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // mark as visited
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
