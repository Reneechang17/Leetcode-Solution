// Medium
// Map
// Time:O(n*d), Space:O(n)
// https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/

import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        // key: digit sum, value: max number for this digit sum
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;

        for (int x : nums) {
            int digitSum = getDigitSum(x);

            if (map.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, x + map.get(digitSum));
                map.put(digitSum, Math.max(x, map.get(digitSum)));
            } else {
                map.put(digitSum, x);
            }
        }
        return maxSum;
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
