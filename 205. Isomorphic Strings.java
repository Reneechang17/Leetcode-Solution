// Easy
// Hash Table
// O(n)
// https://leetcode.cn/problems/isomorphic-strings/

import java.util.*;

class Solution {
    // we need to check the mapping relationship between the char in s and t
    // so we can build two map, one is map char in s to char in t
    // and another map is map char in t to char in s
    public boolean isIsomorphic(String s, String t) {
        // basecase: check the length of s and t
        if (s.length() != t.length()) {
            return false;
        }

        // build two map
        Map<Character, Character> sMapt = new HashMap<>(); // store sChar, tChar
        Map<Character, Character> tMaps = new HashMap<>(); // store tChar, sChar

        // then we iterate the s
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // if the sChar in the sMapt, we need to check if the mapping char is  equal to tChar
            if (sMapt.containsKey(sChar)) {
                if (sMapt.get(sChar) != tChar) {
                    return false;
                }
            } else {
                // put the sChar and tChar to sMapt
                sMapt.put(sChar, tChar);
            }

            // and we also check for tChar in tMaps
            if (tMaps.containsKey(tChar)) {
                if (tMaps.get(tChar) != sChar) {
                    return false;
                }
            } else {
                // put the tChar and sChar to tMaps
                tMaps.put(tChar, sChar);
            }
        }
        return true;
    }
}
