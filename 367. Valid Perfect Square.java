// Easy
// Binary Search
// O(logn)
// https://leetcode.cn/problems/valid-perfect-square/

class Solution {
    public boolean isPerfectSquare(int num) {
        // 判斷是不是完全平方數 -> 即x * x = num
        // 二分 -> 範圍是[1, num]
        int left = 1, right = num;

        while (left <= right) {
            int mid = (left + right) >> 1;

            long square = 1L * mid * mid; // 防止溢出

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
