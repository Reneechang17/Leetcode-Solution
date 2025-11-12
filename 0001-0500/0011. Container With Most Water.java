// Medium
// Two Pointers
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int curArea = minHeight * (right - left);
            maxArea = Math.max(maxArea, curArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
