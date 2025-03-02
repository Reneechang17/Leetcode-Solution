// Medium
// Hash Table, String
// Time:O(n*m),Space:O(n)
// https://leetcode.cn/problems/unique-word-abbreviation/

class ValidWordAbbr {
    private final String[] dic;

    public ValidWordAbbr(String[] dictionary) {
        dic = dictionary;
    }
    
    public boolean isUnique(String word) {
        int n = word.length();
        for (String s : dic) {
            if (word.equals(s)) {
                continue;
            }
            int m = s.length();
            if (m == n && s.charAt(0) == word.charAt(0) && s.charAt(m - 1) == word.charAt(n - 1)) {
                return false;
            }
        }
        return true;
    }
}
