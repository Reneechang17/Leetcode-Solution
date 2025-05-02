// Medium
// Backtracking
// Time:O(n*2^n),Space:O(n)
// https://leetcode.cn/problems/generalized-abbreviation/

import java.util.*;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), word, 0, 0); // index, count
        return res;
    }

    private void backtracking(List<String> res, StringBuilder abbr, String word, int index, int count) {
        int n = abbr.length();

        if (index == word.length()) {
            if (count > 0) abbr.append(count);
            res.add(abbr.toString());
        } else {
            backtracking(res, abbr, word, index + 1, count + 1);

            // for each char, can choose skip or not
            // if no skip cur char, deal with the count first
            if (count > 0) abbr.append(count);
            abbr.append(word.charAt(index)); // than add cur char
            backtracking(res, abbr, word, index + 1, 0);
        }
        abbr.setLength(n);
    }
}
