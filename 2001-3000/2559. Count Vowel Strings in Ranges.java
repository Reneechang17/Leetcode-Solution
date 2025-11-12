// Medium
// Prefix
// Time:O(n+q),Space:O(n)
// https://leetcode.cn/problems/count-vowel-strings-in-ranges/

import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        
        for (int i = 0; i < n; i++) {
            String s = words[i];
            if (set.contains(s.charAt(0)) &&
                    set.contains(s.charAt(s.length() - 1))) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }
        return res;
    }
}
