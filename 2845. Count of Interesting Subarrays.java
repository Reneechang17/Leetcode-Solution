// Medium
// PrefixSum
// Time:O(n), Space:O(modulo)
// https://leetcode.cn/problems/count-of-interesting-subarrays/

import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        // key:prefix%modulo, value:appear time
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int prefix = 0;
        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            if (nums.get(i) % modulo == k) {
                prefix++;
            }

            // 计算目标余数：找的前面有多少个 prefix_j 满足这个条件：
            // (prefix_i - prefix_j) % modulo == k
            // <=> prefix_j % modulo == (prefix_i - k + modulo) % modulo
            int targetMod = (prefix - k + modulo) % modulo;

            // 如果有前缀余数为 targetMod 的，就说明存在这样的前缀差
            res += map.getOrDefault(targetMod, 0);

            // 记录当前 prefix 的 mod 值出现次数
            int curMod = prefix % modulo;
            map.put(curMod, map.getOrDefault(curMod, 0) + 1);
        }
        return res;
    }
}

/**
 * 我们需要找：子数组[i..j]中多少个数%modulo=k，这个数的个数%modulo=k
 * 可以对前缀做统计，表示从头到当前i有多少个数%modulo=k
 * 然后找之前有多少位置j可以=> prefix[i]-prefix[j]=k(mod modulo)
 * => prefix[j]≡(prefix[i]-k+modulo)%modulo
 */
