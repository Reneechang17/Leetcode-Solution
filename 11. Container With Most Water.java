// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/container-with-most-water/

class Solution {
    // Use two pointers to find the max area
    // Calculate the area using the two heights at the pointers and the distance between them
    // Adjust the pointer pointing to the shorter height to find a larger area
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int curArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, curArea);
            // move the pointer pointing to the smallest height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
