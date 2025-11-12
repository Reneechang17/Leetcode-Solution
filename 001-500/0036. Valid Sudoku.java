// Medium
// Set
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/valid-sudoku/

import java.util.*;
class Solution {
    // Use set to ensure each num appear only once in its r/c/subgrid
    // For each non-empty cell, create unique forms(string) for its r/c/block
    // If any form already exists in the set, the board is invalid
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c + "in row" + i) ||
                    !set.add(c + "in col" + j) ||
                    !set.add(c + "in block" + (i / 3) + "-" + (j / 3))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
