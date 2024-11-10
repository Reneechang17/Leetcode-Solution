// Medium
// Matrix
// O(n)
// https://leetcode.cn/problems/spiral-matrix/

import java.util.*;

class Solution {
    // we can iterate the matrix and put the element we go through in res
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        // basecase
        if (matrix.length == 0){
            return res;
        }

        // define the left, right, top and bottom
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // from left to right: top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // from top to bottom: right
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // from right to left: bottom
            // 再检查一次边界是避免重复遍历或是单行单列的情况
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // from bottom to top: left
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
