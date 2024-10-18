// Medium
// Math, Matrix, Array
// O(n^2)
// https://leetcode.cn/problems/rotate-image/

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;

        // 先對角翻
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 再左右翻
        for (int i = 0; i <= n; i++) {
            // j可以減少一半，因為翻一半就翻完了
            for (int j = 0; j <= n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = temp;
            }
        }
    }
}

/**
 * 旋轉圖片
 * 這題硬想很難，通常這種聯想不到算法或是數據結構的題，可以嘗試先觀察規律
 * 通過觀察可以發現，旋轉90度等於先對角翻轉，再左右翻轉
 **/
