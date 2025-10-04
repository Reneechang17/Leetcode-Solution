// Medium
// Binary Search, Greedy
// Time:O(nlogn), Space:O(1)
// https://leetcode.cn/problems/magnetic-force-between-two-balls/

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1, right = position[position.length - 1] - position[0];

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canPlace(position, m, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean canPlace(int[] position, int m, int minDist) {
        int cnt = 1, prev = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= minDist) {
                cnt++;
                prev = position[i];
                if (cnt == m)
                    return true;
            }
        }
        return false;
    }
}
