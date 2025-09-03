// Hard
// Math(Actually more like simulation)
// Time:O(n^2), Space: O(1)
// https://leetcode.cn/problems/find-the-number-of-ways-to-place-people-ii/

import java.util.Arrays;

class Solution {
    // It actually looks pretty similar to 3025...
    // Probably the only diff and hard point is dataset is larger than 3025 -> need optimization
    // Claude told me can use sort to do so...:>
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0]; // asc by x or desc by y when x are same
            return b[1] - a[1];
        });

        int cnt = 0;
        
        for (int i = 0; i < n; i++) {
            int aY = points[i][1]; // aX never use(or need to check)

            // If choose Bob, Bob'y should larger than this val
            int minBobY = Integer.MIN_VALUE;

            // check Bob's position (only focus on Alice' right)
            for (int j = i + 1; j < n; j++) {
                int bY = points[j][1];  // bX never use(or need to check)
                // and Bob should be below Alice
                if (bY > aY)
                    continue;

                if (bY > minBobY) {
                    cnt++;
                    minBobY = bY;
                }
            }
        }
        return cnt;
    }
}
