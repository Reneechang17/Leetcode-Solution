// Medium
// Backtracking
// Time:O(3^4), Space:O(1)
// https://leetcode.cn/problems/restore-ip-addresses/

import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0); // start, dotCount
        return res;
    }

    private void backtracking(StringBuilder s, int start, int dotCount) {
        if (dotCount == 3) {
            if (isValid(s, start, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s.insert(i + 1, '.');
                backtracking(s, i + 2, dotCount + 1);
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    // Validate s[start, end] 
    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            // turn the char to digit
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) return false;
        }
        return true;
    }
}
