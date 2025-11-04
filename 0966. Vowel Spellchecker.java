// Medium
// HashMap/Set
// Time:O(M+N), Space:O(M)
// https://leetcode.cn/problems/vowel-spellchecker/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // perfect match
        Set<String> perfectMatch = new HashSet<>();
        Map<String, String> caseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            perfectMatch.add(w);

            String lower = w.toLowerCase();
            caseMap.putIfAbsent(lower, w);

            String pattern = toVowel(lower);
            vowelMap.putIfAbsent(pattern, w);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (perfectMatch.contains(q)) {
                res[i] = q;
            } else if (caseMap.containsKey(q.toLowerCase())) {
                res[i] = caseMap.get(q.toLowerCase());
            } else if (vowelMap.containsKey(toVowel(q.toLowerCase()))) {
                res[i] = vowelMap.get(toVowel(q.toLowerCase()));
            } else {
                res[i] = "";
            }
        }
        return res;
    }
    
    private String toVowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("aeiou".indexOf(c) >= 0 ? '*' : c);
        }
        return sb.toString();
    }
}
