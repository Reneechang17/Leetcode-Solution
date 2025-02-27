// Medium
// Backtracking
// Time:O(n!), Space:O(n)
// https://leetcode.cn/problems/palindrome-permutation-ii/

import java.util.*;

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();

        // count char appear time
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // check if palindrom is possible
        String mid = "";
        StringBuilder half = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int cnt = entry.getValue();
            if (cnt % 2 != 0) {
                if (mid.isEmpty()) {
                    mid = String.valueOf(c); // for odd
                } else {
                    return res;
                } 
            }
            // add half of the occurs of char to form the half palindrome
            for (int i = 0; i < cnt / 2; i++) {
                half.append(c);
            }
        }

        // generate permutations of the half palindromes
        Set<String> permutations = new HashSet<>();
        generateForms(half.toString(), 0, permutations);

        // construct full palindrome
        for (String h : permutations) {
            String full  = h + mid + new StringBuilder(h).reverse().toString();
            res.add(full);
        }
        return res;
    }
    private void generateForms(String s, int index, Set<String> res) {
        if (index == s.length()) {
            res.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(index)) continue;
            String swapped = swap(s, i, index);
            generateForms(swapped, index + 1, res);
        }
    }

    private String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return new String(arr);
    }
}
