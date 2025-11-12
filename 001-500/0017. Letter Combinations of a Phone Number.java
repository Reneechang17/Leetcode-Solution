// Medium
// Backtracking
// Time:O(4^n), Space:O(n)
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/

import java.util.*;
class Solution {
    // Use Backtracking to explore all possible combinations
    // For each digit, iterate through its mapped letters, append to cur path
    //   and backtrack when the path matches the digits length
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        // bascase
        if (digits == null || digits.length() == 0) return res;
        String[] list = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, list, 0); // 0 means start from fisrt char of digits
        return res;
    }
    private void backtracking(String digits, String[] list, int num) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String match = list[digits.charAt(num) - '0'];
        for (int i = 0; i < match.length(); i++) {
            sb.append(match.charAt(i));
            backtracking(digits, list, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    } 
}
