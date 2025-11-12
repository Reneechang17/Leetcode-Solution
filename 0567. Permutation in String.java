// Medium
// Sliding Window
// Time: O(n), Space: O(1)
// https://leetcode.cn/problems/permutation-in-string/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // calculate the char freq of s1
        int[] cnt1 = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            cnt1[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            // check if they match
            if (matches(cnt1, window)) {
                return true;
            }
        }
        return false;
    }

    private boolean matches(int[] c1, int[] w) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != w[i])
                return false;
        }
        return true;
    }
}
