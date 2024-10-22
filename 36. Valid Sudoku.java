// Medium
// Hash Table
// O(9x9) * O(1) = O(81) -> O(1), the board's size is fixed
// https://leetcode.cn/problems/valid-sudoku/

import java.util.*;

class Solution {
    // 驗證數獨是否有效，保證每個數字在其所在行列和3x3的九宮格內只出現一次，避免重複
    // 去重方法 -> set, build string to display its position in row, col and block, then store in set
    // 為什麼用string標示？ 更好的表示它的唯一性
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String row = num + "in row" + i;
                    String col = num + "in col" + j;
                    String block = num + "in block" + (i / 3) + "-" + (j / 3);

                    if (!set.add(row) || !set.add(col) || !set.add(block)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
