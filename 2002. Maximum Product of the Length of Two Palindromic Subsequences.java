// Medium
// Two Pointers, Bitmask
// Time:O(2^n * n), Space:O(2^n)
// https://leetcode.cn/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

import java.util.*;

class Solution {
    // 可以用bitmask表示所有可能子序列，判断哪些是回文
    // 每对不重叠的回文子序列，计算长度
    public int maxProduct(String s) {
        int n = s.length();
        List<int[]> palindromes = new ArrayList<>();

        // 生成所有可能子序列
        for (int mask = 1; mask < (1 << n); mask++) {
            if (isPalindrome(s, mask)) {
                palindromes.add(new int[]{mask, Integer.bitCount(mask)});
            }
        }

        int max = 0;
        for (int i = 0; i < palindromes.size(); i++) {
            for (int j = i + 1; j < palindromes.size(); j++) {
                int mask1 = palindromes.get(i)[0];
                int len1 = palindromes.get(i)[1];
                int mask2 = palindromes.get(j)[0];
                int len2 = palindromes.get(j)[1];

                // 检查两个子序列是否不重叠（0表示不重叠）
                if ((mask1 & mask2) == 0) {
                    max = Math.max(max, len1 * len2);
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int mask) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();

        // 根据位演码构建子序列
        for (int i = 0; i < len; i++) {
            if (((mask >> i) & 1) == 1) {
                sb.append(s.charAt(i));
            }
        }

        String sub = sb.toString();
        int left = 0, right = sub.length() - 1;
        while (left < right) {
            if (sub.charAt(left) != sub.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
