// Medium
// Hash Table
// O(9x9) * O(1) = O(81) -> O(1), the board's size is fixed
// https://leetcode.cn/problems/valid-sudoku/

import java.util.*;

class Solution {
    // make sure that the num in rows, cols and 3*3 blocks not duplicate
    // we can use set to do it, and to ensure that the pos is only appear once
    // we can use string to build it and store in set
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        // iterate the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String row = num + "in row" + i;
                    String col = num + "in col" + j;
                    String block = num + "in block" + (i / 3) + "-" + (j / 3);

                    // if one of row, col or block cannot add, means it appear already
                    // so that means it have duplicate element, so we can return false
                    if (!set.add(row) || !set.add(col) || !set.add(block)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
