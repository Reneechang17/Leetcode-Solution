// Easy
// Matrix
// Time:O(m*n),Space:O(1)
// https://leetcode.cn/problems/row-with-maximum-ones/

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int max = 0, rowIndex = 0;
        for (int i = 0; i < mat.length; i++) {
            int total = 0;
            for (int j = 0; j < mat[0].length; j++) {
                total += mat[i][j];
            }
            if (total > max) {
                max = total;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, max};
    }
}
