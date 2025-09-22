// Medium
// Math, Map, String
// Time:O(n logm), Space:O(n)
// https://leetcode.cn/problems/number-of-pairs-of-interchangeable-rectangles/

import java.util.*;

class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<String, Long> map = new HashMap<>();
        long total = 0;

        for (int[] rect : rectangles) {
            int w = rect[0], h = rect[1];

            int gcd = getGCD(w, h);
            int simWidth = w / gcd, simHeight = h / gcd;
            String ratio = simWidth + "," + simHeight;

            Long prevForm = map.getOrDefault(ratio, 0L);
            total += prevForm;

            map.put(ratio, prevForm + 1);
        }
        return total;
    }

    private int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
