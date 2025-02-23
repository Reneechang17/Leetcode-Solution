// Hard
// Backtracking
// Time:O(n!),Space:O(n)
// https://leetcode.cn/problems/n-queens-ii/

import java.util.*;

class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>(), diag1 = new HashSet<>(), diag2 = new HashSet<>();
        return backtracking(n, 0, cols, diag1, diag2);
    }
    private int backtracking(int n, int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
        // if all queen put, find a new solution
        if (row == n) return 1;
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) continue;

            // try to put queen
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            count += backtracking(n, row + 1, cols, diag1, diag2);

            // backtracking
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
        return count;
    }
}
