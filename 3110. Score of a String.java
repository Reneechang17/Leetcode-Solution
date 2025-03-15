// Easy
// Iteration
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/score-of-a-string/

class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }
}
