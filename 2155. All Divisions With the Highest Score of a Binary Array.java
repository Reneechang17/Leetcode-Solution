// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/all-divisions-with-the-highest-score-of-a-binary-array/

import java.util.*;

// This question's statement somehow looks much complicated than it actually wants to talk...:D

class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length, one = 0;
        for (int x : nums) {
            one += x; // calculate how many one
        }

        int leftZero = 0, maxScore = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            int score = leftZero + one;

            if (score > maxScore) {
                maxScore = score;
                res.clear();
                res.add(i);
            } else if (score == maxScore) {
                res.add(i);
            }

            if (i < n) {
                if (nums[i] == 0)
                    leftZero++;
                else
                    one--;
            }
        }
        return res;
    }
}
