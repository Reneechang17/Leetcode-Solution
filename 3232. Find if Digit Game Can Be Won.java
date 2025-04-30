// Easy
// Iteration
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/find-if-digit-game-can-be-won/

class Solution {
    public boolean canAliceWin(int[] nums) {
        int singleSum = 0, doubleSum = 0;
        for (int x : nums) {
            if (x < 10) {
                singleSum += x;
            } else {
                doubleSum += x;
            }
        }
        return singleSum != doubleSum;
    }
}

// 其实很简单，Alice赢面很大，可以计算所有单数和和双数和，哪个大alice就选哪个。唯一可能会输的情况是相等。
