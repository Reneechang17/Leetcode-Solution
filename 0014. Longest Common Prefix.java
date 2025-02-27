// Easy
// String, prefix
// Time:O(n * m), first loop to find the shortest str, second loop to iterate all strings
// Space:O(m), m is the length of the shortest string
// https://leetcode.cn/problems/longest-common-prefix/

class Solution {
    // Iterate the strs to find the shortest string as the initial prefix 
    // since common prefix can't exceed its length
    // Then iterate again, if any s can't use the prefix, cut the length
    public String longestCommonPrefix(String[] strs) {
        // basecase
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs) {
            if (s.length() < prefix.length()) {
                prefix = s;
            }
        }
        for (String s : strs) {
            // if any s can't use prefix as common start->cut it
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
