// Easy
// Matrix
// Time:O(m*n),Space:O(m*n)
// https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

import java.util.*;

class Solution {
    public int[] spiralArray(int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return new int[0];
        int m = array.length, n = array[0].length;
        
        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(array[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(array[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(array[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(array[i][left]);
                }
                left++;
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
