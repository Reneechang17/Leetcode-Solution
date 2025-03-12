// Easy
// Iteration
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/find-the-k-beauty-of-a-number/

class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int n = s.length(), res = 0;
        for (int i = 0; i <= n - k; i++) {
            String subStr = s.substring(i, i + k);
            int val = Integer.parseInt(subStr);
            if (val != 0 && num % val == 0) res++;
        }
        return res;
    }
}
