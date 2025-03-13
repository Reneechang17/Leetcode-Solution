// Medium
// Sliding Window, Hash Table
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

import java.util.*;

class Solution {
    public long countOfSubstrings(String word, int k) {
        // diff contains k's consonants
        return count(word, k) - count(word, k + 1);
    }
    
    public long count(String word, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int n = word.length(), count = 0, j = 0;
        long ans = 0;
        // (vowel, its appear time)
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // move right pointer until meet conditions
            while (j < n && (count < k || map.size() < 5)) {
                char c = word.charAt(j);
                if (set.contains(c)) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                } else {
                    count++;
                }
                j++;
            }
            if (count >= k && map.size() == 5) {
                ans += n - j + 1;
            }
            // move left pointer
            char left = word.charAt(i);
            if (set.contains(left)) {
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
            } else {
                count--;
            }
        }
        return ans;
    }
}
