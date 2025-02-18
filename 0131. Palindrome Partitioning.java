// Medium
// Backtracking
// Time:O(n2^n), Space:O(n)
// https://leetcode.cn/problems/palindrome-partitioning/

import java.util.*;
class Solution {
    // Use backtrack to find all possible ways to partition the string
    // At each pos, check if substring is palindrome and recurse for remaining str
    // If reach the end of str, add cur partition to the res
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtracking(s, 0, path, res);
        return res;
    }
    private void backtracking(String s, int start, List<String> path, List<List<String>> res) {
        // if reach the end of string, add cur path to res
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        // try to partition at each position
        for (int end = start; end < s.length(); end++) {
            // check palindrome for substring
            if (isValid(s, start, end)) {
                // add this substring to the cur path
                path.add(s.substring(start, end + 1));
                backtracking(s, end + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
