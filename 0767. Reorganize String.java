// Medium
// Heap
// Time:O(nlogk),Space: O(n)
// https://leetcode.cn/problems/reorganize-string/

import java.util.*;
class Solution {
    // Use map store freq of each char, if freq over the half of length, return empty
    // Use maxHeap and sort with the freq from high to low, every time take two most freq char from heap
    //   - put in res and update freq, if there are any left, put them back into heap
    // If the heap left one char and its freq is 1, we can put to the tail of string
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            if (map.get(c) > (s.length() + 1) / 2) {
                return "";
            }
            maxHeap.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (maxHeap.size() > 1) {
            // every time take two out
            char first = maxHeap.poll();
            char sec = maxHeap.poll();
            sb.append(first);
            sb.append(sec);
            // update freq
            map.put(first, map.get(first) - 1);
            map.put(sec, map.get(sec) - 1);
            // if remain, put in heap
            if (map.get(first) > 0) maxHeap.offer(first);
            if (map.get(sec) > 0) maxHeap.offer(sec);
        }
        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll());
        }
        return sb.toString();
    }
}
