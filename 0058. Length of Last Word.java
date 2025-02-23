// Easy
// String
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/length-of-last-word/

class Solution {
    // Since there are blank after last word -> clear the space first
    // Then iterate from last one, if occur space, break it
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int ans = 0; 
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            ans++;
        }
        return ans;
    }
}
