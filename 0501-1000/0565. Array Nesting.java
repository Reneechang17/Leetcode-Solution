// Medium
// Simulation
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/array-nesting/

class Solution {
    // Simulate path and mark vis element
    // Iterate arr and find the start unvis start i, nums[i]->nums[nums[i]]->...
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        boolean[] vis = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                int start = i, cnt = 0;
                while (!vis[start]) {
                    vis[start] = true;
                    start = nums[start];
                    cnt++;
                }
                maxLen = Math.max(maxLen, cnt);
            }
        }
        return maxLen;
    }
}
