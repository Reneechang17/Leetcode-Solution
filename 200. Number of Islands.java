// Medium
// Graph, DFS
// O(m * n)
// https://leetcode.cn/problems/number-of-islands/

class Solution {
    // 這題可以看作是一個圖，這題找的就是圖的連通分量（即島嶼）
    // BFS from one island and search its four directions 
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        int rows = grid.length;
        int cols = grid[0].length;

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

    // search for four directions
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // mark as 0 means has visited already

        dfs(grid, i - 1, j); // up
        dfs(grid, i + 1, j); // down
        dfs(grid, i, j - 1); // left
        dfs(grid, i, j + 1); // right
    }
}
