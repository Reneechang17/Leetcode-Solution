// Easy
// Counting
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/three-consecutive-odds/

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int x : arr) {
            if (x % 2 == 1) {
                cnt++;
                if (cnt == 3) return true;
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}
