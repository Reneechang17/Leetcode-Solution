// Hard
// DP
// Time:O(n^2), Space:O(n^2)
// https://leetcode.cn/problems/palindrome-partitioning-ii/

class Solution {
    // Use DP to calculate the min cuts needed for partition str to palindromic substrings
    //  - The dp array stores the min cuts required for the substring s[0...i]
    // For each character, check all substrings ending at that character
    //  - if the substring is palindromic, update the dp array to min cuts
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        // boolean arr represent whether s[i..j] is palindrome
        boolean[][] isValid = new boolean[n][n];

        // initialize the worse case: cut after every char
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // check if s[i..j] is palindrome
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || isValid[j + 1][i - 1])) {
                    isValid[j][i] = true;
                    // if sub start at 0, no need for cut
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
