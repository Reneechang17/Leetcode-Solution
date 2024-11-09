// Easy
// String
// brute force -> O(m*n), KMP -> O(m+n)
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        // iterate the haystack, i is cur start in haystack
        for (int i = 0; i <= m - n; i++) {
            int j = 0; // j is use to iterate the needle
            // check if haystack[i + j] equal to needle[j]
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // if j == n, means we match all the char in needle
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
