// Easy
// String
// Time:O(m*n) for brute force, Space:O(1)
// KMP -> O(m+n)
// https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/

class Solution {
    // Iterate through haystack, start from each possible pos i
    // For each pos, compare chars in haystack and needle
    // If all chars in needle match, return the cur index
    // If no match is found after iteration, return -1
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0; i <= m - n; i++) {
            int j = 0; // j use to iterate the needle
            // check if haystack[i + j] equal to needle[j]
            while (j < n && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // if j == n, means we match all chars in needle
            if (j == n) return i;
        }
        return -1;
    }
}
