// Medium
// Difference Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/car-pooling/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] t : trips) {
            int num = t[0], from = t[1], to = t[2];
            diff[from] += num;
            diff[to] -= num;
        }

        int cur = 0;
        for (int i = 0; i < 1001; i++) {
            cur += diff[i];
            if (cur > capacity)
                return false;
        }
        return true;
    }
}
