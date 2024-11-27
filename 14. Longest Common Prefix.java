// Easy
// String, prefix
// Time:O(n * m), first loop to find the shortest str, second loop to iterate all strings
// Space:O(m), m is the length of the shortest string
// https://leetcode.cn/problems/longest-common-prefix/

class Solution {
    // First, find the shortest string as the initial prefix since the common prefix cannot exceed its length
    // Then, iterate all strings, if any word cannot use s as prefix -> shrink it
    public String longestCommonPrefix(String[] strs) {
        // basecase
        if (strs.length == 0 || strs == null) return "";

        String prefix = strs[0];
        for (String s : strs) {
            if (s.length() < prefix.length()) {
                prefix = s;
            }
        }

        for (String s : strs) {
            // If any word cannot use s as prefix -> shrink it
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
