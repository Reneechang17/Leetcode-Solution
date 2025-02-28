// Easy
// Binary Search
// Time:O(logn),Space:O(1)
// https://leetcode.cn/problems/valid-perfect-square/

class Solution {
    // Check if num is a perfect square -> meaning x * x = num
    // Use Binary Search to find the square root in range[1, num]
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = 1L * mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
