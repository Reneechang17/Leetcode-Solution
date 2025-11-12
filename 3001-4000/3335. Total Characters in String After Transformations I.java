// Medium
// Simulation
// Time:O(t*26),Space:O(1)
// https://leetcode.cn/problems/total-characters-in-string-after-transformations-i/

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        final int MOD = 1000000007;

        for (int i = 0; i < t; i++) {
            int[] newCnt = new int[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) { // 'z'
                    newCnt[0] = (newCnt[0] + cnt[j]) % MOD; // a
                    newCnt[1] = (newCnt[1] + cnt[j]) % MOD; // b
                } else {
                    newCnt[j + 1] = (newCnt[j + 1] + cnt[j]) % MOD;
                }
            }
            cnt = newCnt;
        }
        int totalLength = 0;
        for (int x : cnt) {
            totalLength = (totalLength + x) % MOD;
        }
        return totalLength;
    }
}
