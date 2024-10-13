// Medium
// Array, Matrix
// O(m * n * k)
// https://leetcode.cn/problems/sparse-matrix-multiplication/

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        int[][] res = new int[m][n];

        // 針對mat1 -> 只考慮對非零的元素做操作
        for (int i = 0; i < m; i++) {
            for (int p = 0; p < k; p++) {
                if (mat1[i][p] != 0) {
                    // 針對mat2 -> 只考慮mat2[p][j]中非零的部分
                    for (int j = 0; j < n; j++) {
                        if (mat2[p][j] != 0) {
                            res[i][j] += mat1[i][p] * mat2[p][j];
                        }
                    }
                }
            }
        }
        return res;
    }
}

/**
 * 稀疏矩陣的乘法：實現兩個稀疏矩陣的乘法，並返回結果矩陣
 * 稀疏矩陣指的是大部分元素都是0的矩陣，因此我們需要優化計算，只對非零元素計算來提高效率
 * 
 * 給定兩個矩陣mat1和mat2，矩陣的大小分別是m*k和k*n，要求返回兩個矩陣的乘積，也就是m*n的矩陣
 * 對於結果矩陣的C[i][j]，它的值是由mat1的第i行和mat2的第j列相乘再相加得到的
 **/
