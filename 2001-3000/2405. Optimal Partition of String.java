// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/optimal-partition-of-string/

import java.util.*;

class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int partition = 1; // at least 1

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                partition++;
                set.clear();
            }
            set.add(c);
        }
        return partition;
    }
}
