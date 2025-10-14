// Easy
// Math
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/

// Odd cnt from 0 to N, if n is odd -> (n+1)/2; if n is even -> n/2
// [low, high] = [0, high] - [0, low - 1]
class Solution {
    public int countOdds(int low, int high) {
        return countOddsFromZero(high) - countOddsFromZero(low - 1);
    }

    private int countOddsFromZero(int n) {
        if (n < 0)
            return 0;
        return (n + 1) / 2;
    }
}
