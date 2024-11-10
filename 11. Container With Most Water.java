// Medium
// Two Pointers
// O(n)
// https://leetcode.cn/problems/container-with-most-water/

class Solution {
    // use two pointers to solve
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int curArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, curArea);

            // keep to adjust the pointers
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
