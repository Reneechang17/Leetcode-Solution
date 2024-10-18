// Medium
// Array, Matrix
// O(n)
// https://leetcode.cn/problems/spiral-matrix/

import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0)
            return res;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                res.add(matrix[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    res.add(matrix[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
}

/**
 * 螺旋矩陣思路：一個while四個for
 * 這題只需要遍歷打印即可
 * 初始化：
 * top = 0
 * bottom = matrix.length - 1
 * left = 0
 * right = matrix[0].length -1
 * 
 * while循環條件：top <= bottom && left <= right
 * 四個for循環處理四個邊界情況
 **/