// Medium
// DFS
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/surrounded-regions/

class Solution {
    // Mark all 'O's connected to the boundary as 'B'
    // Then traverse the board to replace:
    //   - Remaining 'O' with 'X' (captured regions)
    //   - 'B' back to 'O' (escaped regions)
    public void solve(char[][] board) {
        // basecase
        if (board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;

        // Traverse the boundary to find 'O' and mark as 'B'
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0); // left boundary
            dfs(board, i, col - 1); // right boundary
        }
        for (int j = 0; j < col; j++) {
            dfs(board, 0, j); // top boundary
            dfs(board, row - 1, j); // bottom boundary
        }

        // Traverse the board to convert
        // 'O' -> 'X', 'B' -> 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'B';
        // dfs to four directions
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
