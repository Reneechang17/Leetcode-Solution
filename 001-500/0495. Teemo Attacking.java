// Easy
// Simulation
// Time:O(n), Space: O(1)
// https://leetcode.cn/problems/teemo-attacking/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0)
            return 0;
        int total = 0;

        for (int i = 0; i < timeSeries.length - 1; i++) {
            int gap = timeSeries[i + 1] - timeSeries[i];
            total += Math.min(gap, duration);
        }

        // Last attack will add full duration
        total += duration;
        return total;
    }
}
