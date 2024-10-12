// Medium
// Sliding Window, Hash Table
// O(n)
// https://leetcode.cn/problems/repeated-dna-sequences/

import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // 返回長度為10，出現超過1次的DNA子序列
        // 滑動窗口截取，哈希表紀錄它是否出現過
        List<String> res = new ArrayList<>();
        if (s.length() < 10) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                res.add(key);
            }
        }
        return res;
    }
}
