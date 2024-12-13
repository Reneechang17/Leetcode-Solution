// Easy
// Binary Search
// Time:O(logn), Space:O(1)
// https://leetcode.cn/problems/sqrtx/

class Solution {
    // Use binary search to find the integer part of the square root
    // The square root will not exceed x/2 for x>=2
    // Check mid^2 against x to adjust the search range
    public int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long s = (long) mid * mid;
            if (s == x) {
                return mid;
            } else if (s < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right; // right is the largest integer <= sqrt(x)
    }
}
