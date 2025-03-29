// Easy
// Counting
// Time:O(n),Space:O(1)
// https://leetcode.cn/problems/minimize-string-length/

class Solution {
    public int minimizedStringLength(String s) {
        int[] arr = new int[26];
        int res = 0;
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
            if (arr[c - 'a'] == 1) res++;
        }
        return res;
    }
}
