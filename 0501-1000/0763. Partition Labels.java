// Medium
// Greedy, String
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/partition-labels/

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastPos[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastPos[s.charAt(i) - 'a']);

            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
