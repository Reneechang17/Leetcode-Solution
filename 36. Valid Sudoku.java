// Medium
// Hash Table
// Time:O(81)->(1),fixed board size. Space:O(1)
// https://leetcode.cn/problems/valid-sudoku/

import java.util.*;

class Solution {
    // make sure that the num in rows, cols and 3*3 blocks only appear once
    // we can use set to ensure the pos is only appear once and 
    // use String to build it as unique identifier, then store in set
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
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
