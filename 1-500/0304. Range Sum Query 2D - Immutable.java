// Medium
// Matrix, Prefix Sum
// Time:O(m*n)&O(1),Space:O(m*n)
// https://leetcode.cn/problems/range-sum-query-2d-immutable/

class NumMatrix {
    // Use prefix to precompute the sum of submatrix from(0,0) to (i-1, j-1)
    // For each region(row1, col1) to (row2, col2), calculate target region sum:
    //  - sum = prefixSum[row2][col2]-prefixSum[row1-1][col2]-prefixSum[row2][col1-1]+prefixSum[row1-1][col1-1]
    
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        prefix = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] 
                            + prefix[i - 1][j] 
                            + prefix[i][j - 1] 
                            - prefix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
               - prefix[row1][col2 + 1]
               - prefix[row2 + 1][col1]
               + prefix[row1][col1];
    }
}
