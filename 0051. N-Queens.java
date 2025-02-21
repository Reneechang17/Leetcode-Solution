// Hard
// Backtracking
// Time:O(n!),Space:O(n^2)
// https://leetcode.cn/problems/n-queens/

import java.util.*;
class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // initialize chessboard
        char[][] chessboard = new char[n][n];
        for (char[] row : chessboard) {
            Arrays.fill(row, '.');
        }
        backtracking(n, 0, chessboard); // backtrack from row 0
        return res;
    }
    private void backtracking(int n, int row, char[][] chessboard) {
        if (row == n) {
            res.add(arrayToList(chessboard));
            return;
        }
        // for cur row, try to put queen on each col
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }
    private List<String> arrayToList(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] row : chessboard) {
            list.add(String.copyValueOf(row));
        }
        return list;
    }
    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        // check same col
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') return false;
        }
        // check 45
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') return false;
        }
        // check 135
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') return false;
        }
        return true;
    }
}
