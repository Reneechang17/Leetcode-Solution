// Medium
// Math, Array, Two Pointers
// O(n)
// https://leetcode.com/problems/sort-transformed-array/

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] sorted = new int[n];
        int left = 0, right = n - 1;
        int index = a >= 0 ? n - 1 : 0;

        while (left <= right) {
            int leftVal = transform(nums[left], a, b, c);
            int rightVal = transform(nums[right], a, b, c);
            // 'a' can determine whether the parabola is going up or down.
            if (a >= 0) {
                // if the parabola opens upwards, start filling from the end of the array.
                if (leftVal >= rightVal) {
                    sorted[index--] = leftVal;
                    left++;
                } else {
                    sorted[index--] = rightVal;
                    right--;
                }
                // otherwise, start filling from the start of the array
            } else {
                if (leftVal <= rightVal) {
                    sorted[index++] = leftVal;
                    left++;
                } else {
                    sorted[index++] = rightVal;
                    right--;
                }
            }
        }
        return sorted;
    }

    private int transform(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}

/**
 * Note: a可以決定拋物線向上還是向下
 * 如果拋物線向上開口，就從數組的末尾開始填充，反之亦然
 * 
 * 代碼：
 * 1. 初始化：先開一個sorted數組，定義左右指針（分別指向頭尾），以及index（當a>=0，就從數組結尾填，<0從開頭填）
 * 2. 用helper function先計算一下左右指針指向的值
 * 3. 判斷從頭填還是從尾填，如果從尾填的話，先填大的，從頭填的話，先填小的（比較leftVal和rightVal值）
 **/