// Medium
// Sliding Window, Counting
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/

class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length(), res = n;
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        if (count[0] >= k && count[1] >= k && count[2] >= k) {
            res = Math.min(res, n);
        } else {
            return -1;
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']--;
            while (left < right && (count[0] < k || count[1] < k || count[2] < k)) {
                count[s.charAt(left) - 'a']++;
                left++;
            }
            if (count[0] >= k && count[1] >= k && count[2] >= k) {
                res = Math.min(res, n - (right - left + 1));
            }
        }
        return res;
    }
}
