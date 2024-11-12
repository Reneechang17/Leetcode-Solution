// Medium
// Intervals, Greedy
// O(nlogn)
// https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/

import java.util.Arrays;

class Solution {
    // if the cur' start is bigger than the prev's end, we need one more arrow
    // otherwise, means the cur one can be covered by prev
    // than we update the end to the smaller one between cur' end and prev' end
    public int findMinArrowShots(int[][] points) {
        // Using Integer.compare avoids overflow issues when handling large integers with opposite signs
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                // choose the smaller one to ensure we can use the same arrow
                // for shooting more balloons
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return count;
    }
}
