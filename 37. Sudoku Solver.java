// Hard
// Backtracking, DFS
// Time:O(9^(n)), Space:O(n)
// https://leetcode.cn/problems/sudoku-solver/

class Solution {
    // Backtracking to solve the Sudoku:
    // For each empty cell, try placing digits '1' to '9'
    // Use helper to check if the digit is valid in the r/c/block
    // If valid, place the digit and recurse to the next cell. If stuck, backtrack
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    private boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // skip when occur non-empty cell
                if (board[i][j] != '.') continue; 
                // try to fill 1-9 to (i, j), and check if valid
                for (char k = '1'; k <= '9'; k++) {
                    if (isValid(i, j, k, board)) {
                        board[i][j] = k;
                        if (helper(board)) {
                            return true;
                        }
                        // backtrack
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    private boolean isValid(int row, int col, char val, char[][] board) {
        // check row and col for duplicate
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val || board[i][col] == val) return false;
        }
        // check 3X3 block
        int r = (row / 3) * 3, c = (col / 3) * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        return true;
    }
}
