// Medium
// Matrix
// Time:O(n² logn),Space:O(n)
// https://leetcode.cn/problems/sort-matrix-by-diagonals/

import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int r = n - 1; r >= 0; r--) {
            sort(grid, r, 0, false); // ascending=false
        }
        for (int c = 1; c < n; c++) {
            sort(grid, 0, c, true);
        }
        return grid;
    }

    private void sort(int[][] a, int r0, int c0, boolean flag) {
        int n = a.length;
        List<Integer> buf = new ArrayList<>();
        int r = r0, c = c0;
        while (r < n && c < n) {
            buf.add(a[r][c]);
            r++;
            c++;
        }
        buf.sort(flag ? Comparator.naturalOrder() : Comparator.reverseOrder());
        r = r0;
        c = c0;
        int i = 0;
        while (r < n && c < n) {
            a[r][c] = buf.get(i++);
            r++;
            c++;
        }
    } 
}
