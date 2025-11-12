// Medium
// HashTable, String
// Time:O(N*K),Space:O(N*K)
// https://leetcode.cn/problems/group-shifted-strings/

import java.util.*;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            // calculate the diff of each string
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int diff = (s.charAt(i) - s.charAt(i - 1) + 26) % 26;
                sb.append(diff).append(",");
            }

            // use diff as key, string as value
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

// 判断每个字符串是否是shifted版本的另一个字符串
// 例如 "abc"和"zab"的字符差分别为：
// a->z的差为-1或25， b->a的差为-1或25，c->b的差为-1或25
// 可以计算字符串中相邻字符的差值，并将其标准化mod26，判断是否为相同的移位版本
// 再使用哈希表将标准化后的差值作为key，相同差值的字符串为value归类为一组
