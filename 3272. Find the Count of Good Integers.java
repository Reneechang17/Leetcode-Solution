// Hard
// Math
// Time:O(10^(n/2) × n),Space:O(10^(n/2) × n)
// https://leetcode.cn/problems/find-the-count-of-good-integers/

import java.util.*;

class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> set = new HashSet<>();
        int base = (int)Math.pow(10, (n - 1) / 2);
        int skip = n & 1; // check if n is odd

        // 枚举所有n位回文数
        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);

            // 如果当前回文数可以被k整除
            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
            }
        }
        // 计算阶乘值用于后面的排列计数
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long ans = 0;
        for (String s : set) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }

            // 计算排列数+处理leading 0
            long total = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                total /= factorial[x];
            }
            
            ans += total;
        }
        return ans;
    }
}
