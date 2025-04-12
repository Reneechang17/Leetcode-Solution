// Hard
// Greedy, Math
// Time:O(L),Space:O(L)
// https://leetcode.cn/problems/find-the-closest-palindrome/

import java.util.*;

class Solution {
    public String nearestPalindromic(String n) {
        // 将input转成long
        long selfNum = Long.parseLong(n);
        long ans = -1;

        List<Long> candidates = getCandidates(n);

        for (long c : candidates) {
            if (c != selfNum) {
                // 找差值最小的，差值相同选较小的
                if (ans == -1 ||
                        Math.abs(c - selfNum) < Math.abs(ans - selfNum) ||
                        Math.abs(c - selfNum) == Math.abs(ans - selfNum) && c < ans) {
                    ans = c;
                }
            }
        }
        return Long.toString(ans);
    }

    private List<Long> getCandidates(String n) {
        int len = n.length();

        List<Long> candidates = new ArrayList<Long>() {
            {
                add((long) Math.pow(10, len - 1) - 1);
                add((long) Math.pow(10, len) + 1);
            }
        };

        // 获取原数前半部分
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        // 考虑前缀-1、前缀不变、前缀+1
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();

            // 构建前缀
            String prefix = String.valueOf(i);
            sb.append(prefix);

            // 构建后缀（镜像前缀）
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));

            String candidate = sb.toString();

            try {
                // 将构建的回文字符串转为长整型并添加到候选列表
                candidates.add(Long.parseLong(candidate));
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        return candidates;
    }
}

/**
 * 只需要考虑五种可能的回文数:
 * 1. 原数前缀不变的镜像回文数
 * 2. 原数前缀+1的镜像回文数
 * 3. 原数前缀-1的镜像回文数
 * 4. 比原数少一位的最大回文数 (如 999)
 * 5. 比原数多一位的最小回文数 (如 10001)
 * 
 * 对于n位数字，我们只需要确定前(n+1)/2位，然后将前缀镜像作为后缀，对于奇数长度需要跳过中间字符(使用len & 1处理)：
 * - 当len为偶数时，len & 1 = 0，不跳过任何字符
 * - 当len为奇数时，len & 1 = 1，跳过镜像的第一个字符(避免重复中间字符)
 */
