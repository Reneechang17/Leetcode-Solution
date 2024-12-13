// Medium
// Matrix
// Time:O(n)-> n=row*col, Space:O(n)
// https://leetcode.cn/problems/spiral-matrix/

import java.util.*;

class Solution {
    // Traverse the matrix in spiral order: top -> right -> bottom -> left
    // Gradually shrink the boundaries after completing each directional traversal
    // Stop it when top exceeds bottom or left exceed right
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // basecase
        if (matrix.length == 0) return res;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // from left to right on top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // from top to bottom on right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            // from right to left on bottom
            // check if it still valid avoid edge case like single row or col
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // from bottom to top on left
            // check if it still valid avoid edge case like single row or col
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
