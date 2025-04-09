// Easy
// Two Pointers
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/two-furthest-houses-with-different-colors/

class Solution {
    // Brute force: compare all house-pair
    // Use Two Pointers to optimize: one from left, and one from right 
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0, right = n - 1;
        while (colors[right] == colors[0]) {
            right--;
        }
        while (colors[left] == colors[n - 1]) {
            left++;
        }
        return Math.max(right, n - 1 - left);
    }
}
