// Medium
// Sliding Window, Hash Set
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/repeated-dna-sequences/

import java.util.*;
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> occur = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String sub = s.substring(i, i + 10);
            // if substring occured before, add it to res
            if (occur.contains(sub)) {
                res.add(sub);
            } else {
                // or, add it to occur set
                occur.add(sub);
            }
        }
        return new ArrayList<>(res);
    }
}
