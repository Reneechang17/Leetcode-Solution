// Easy
// Map
// Time:O(n*d), Space:O(10)->O(1)
// https://leetcode.cn/problems/max-pair-sum-in-an-array/

import java.util.*;

class Solution {
    public int maxSum(int[] nums) {
        // Find the biggest digit
        // Pair if found
        // Update the max value
        // Map -> key: biggest digit, value: biggest value with that digit
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int x : nums) {
            int maxDigit = getMaxDigit(x);

            if (map.containsKey(maxDigit)) {
                maxSum = Math.max(x + map.get(maxDigit), maxSum);
                map.put(maxDigit, Math.max(x, map.get(maxDigit)));
            } else {
                map.put(maxDigit, x);
            }
        }
        return maxSum;
    }

    private int getMaxDigit(int x) {
        int max = 0;
        while (x > 0) {
            max = Math.max(max, x % 10);
            x /= 10;
        }
        return max;
    }
}
