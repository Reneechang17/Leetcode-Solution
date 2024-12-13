// Medium
// Heap
// Time:O(nlogk), but k is limit to 26, so it is O(n)
// Space: O(n)
// https://leetcode.cn/problems/reorganize-string/

import java.util.*;

class Solution {
  // Use map to store the freq of each char, if the freq over the half of length, return empty
  // Use maxHeap and sort with the freq from high to low, every time we take two most freq char from heap
  //  put them in res and update their freq, and if there are any left, put them back into heap
  // If the heap left one char and its freq is 1, we can put to the tail of string
  public String reorganizeString(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
          map.put(c, map.getOrDefault(c, 0) + 1);
      }
      PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
      for (char c : map.keySet()) {
          // if any char occur more than (s.length() + 1)/2 -> impossible
          if (map.get(c) > (s.length() + 1) / 2) {
              return "";
          }
          // or put the char in maxHeap
          maxHeap.offer(c);
      }
      StringBuilder sb = new StringBuilder();
      // > 1 since every time we need to take two out
      while (maxHeap.size() > 1) {
          char first = maxHeap.poll();
          char second = maxHeap.poll();
          sb.append(first);
          sb.append(second);
          // decrease the freq and add back if still remain
          map.put(first, map.get(first) - 1);
          map.put(second, map.get(second) - 1);
          if (map.get(first) > 0) maxHeap.offer(first);
          if (map.get(second) > 0) maxHeap.offer(second);
      }
      if (!maxHeap.isEmpty()) {
          sb.append(maxHeap.poll());
      }
      return sb.toString();
  }
}
