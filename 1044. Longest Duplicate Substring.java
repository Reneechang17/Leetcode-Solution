// Hard
// Rolling Hash, Binary Search
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/longest-duplicate-substring/

import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        Random random = new Random();
        // 生成两个二进制
        int a1 = random.nextInt(75) + 26, a2 = random.nextInt(75) + 26;
        // 生成两个mod
        int mod1 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int mod2 = random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007;
        int n = s.length();
        // 对所有字符编码
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        // 二分[1,n-1]
        int left = 1, right = n - 1, length = 0, start = -1;
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            int index = check(arr, mid, a1, a2, mod1, mod2);
            if (index != -1) {
                left = mid + 1;
                length = mid;
                start = index;
            } else {
                right = mid - 1;
            }
        }
        return start != -1 ? s.substring(start, start + length) : "";
    }
    private int check(int[] arr, int m, int a1, int a2, int mod1, int mod2) {
        int n = arr.length;
        long aL1 = pow(a1, m, mod1), aL2 = pow(a2, m, mod2), h1 = 0, h2 = 0;
        for (int i = 0; i < m; i++) {
            h1 = (h1 * a1 % mod1 + arr[i] % mod1);
            h2 = (h2 * a2 % mod2 + arr[i] % mod2);
            if (h2 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
        }
        // 存储一个编码组合是否出现过
        Set<Long> set = new HashSet<Long>();
        set.add(h1 * mod2 + h2);
        for (int start = 1; start <= n - m; start++) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1;
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2;
            if (h1 < 0) {
                h1 += mod1;
            }
            if (h2 < 0) {
                h2 += mod2;
            }
            long num = h1 * mod2 + h2;
            // 如果重复，返回重复串的起点
            if (!set.add(num)) {
                return start;
            }
        }
        return -1;
    }
    private long pow(int a, int mid, int mod) {
        long res = 1, contribute = a;
        while (mid > 0) {
            if (mid % 2 == 1) {
                res = res * contribute % mod;
                if (res < 0) {
                    res += mod;
                }
            }
            contribute = contribute * contribute % mod;
            if (contribute < 0) {
                contribute += mod;
            }
            mid /= 2;
        }
        return res;
    }
}
