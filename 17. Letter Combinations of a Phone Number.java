// Medium
// Backtracking
// O(3^n * 4^m)
// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/

import java.util.*;

class Solution {
    // 這題本質上還是一個組合問題，可以想到回溯，因為我們要找所有可能性
    // 每次遞歸的時候選擇數字對應的字母，加入當前路徑中，如果路徑長度等於digit長度時，就找到一個組合
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0 || digits == null) return res;
        String[] numList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 0 means start from the first char of the digits
        backtracking(digits, numList, 0); 
        return res;
    }

    StringBuilder sb = new StringBuilder();

    private void backtracking(String digits, String[] numList, int num) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String matchNum = numList[digits.charAt(num) - '0'];
        for (int i = 0; i < matchNum.length(); i++) {
            sb.append(matchNum.charAt(i));
            backtracking(digits, numList, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
