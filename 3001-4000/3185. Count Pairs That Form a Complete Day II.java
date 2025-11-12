// Medium
// Array
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/

// Same as 1010

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long cnt = 0;
        int[] remainder = new int[24];

        for (int h : hours) {
            int mod = h % 24;

            int target = (24 - mod) % 24;
            cnt += remainder[target];

            remainder[mod]++;
        }
        return cnt;
    }
}
