// Easy
// String
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/count-prefixes-of-a-given-string/

class Solution {
    public int countPrefixes(String[] words, String s) {
        int cnt = words.length;
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                if (!(i < s.length() && w.charAt(i) == s.charAt(i))) {
                    cnt--;
                    break;
                }
            }
        }
        return cnt;
    }
}
