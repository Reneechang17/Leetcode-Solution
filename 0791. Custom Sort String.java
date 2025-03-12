// Medium
// Custom Sorting
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/custom-sort-string/

import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        // use hashmap to record the char order in order
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr, (a, b) -> {
            Integer posA = map.getOrDefault(a, Integer.MAX_VALUE);
            Integer posB = map.getOrDefault(b, Integer.MAX_VALUE);
            return posA - posB;
        });

        StringBuilder sb = new StringBuilder(arr.length);
        for (Character c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
