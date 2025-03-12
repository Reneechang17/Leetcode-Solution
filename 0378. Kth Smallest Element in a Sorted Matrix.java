// Medium
// Matrix, Binary Search
// Time:O(n * log(max - min)),Space:O(1)
// https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    // Smallest:matrix[0][0], largest:matrix[n-1][n-1]
    // Use binary search to find and calculate the element <= mid
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(matrix, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int count(int[][] matrix, int target) {
        int n = matrix.length, row = n - 1, col = 0, cnt = 0;
        while (row >= 0 && col < n) {
            // iterate matrix from top-right, if cur element is smaller than target
            // -> all element in cur row are smaller than target
            if (matrix[row][col] <= target) {
                cnt += (row + 1); // count all elements in this row are <= target
                col++;
            } else {
                row--;
            }
        }
        return cnt;
    }
}

// 相当于两次二分，主方法是用二分找到第k小的数，count方法是用二分找到小于等于mid的数的个数
