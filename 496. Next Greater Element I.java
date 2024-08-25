// Easy
// Hash Table, Monotonic Stack
// O(n + m)
// https://leetcode.com/problems/next-greater-element-i/

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer> stack = new Stack<>();
      Map<Integer, Integer> map = new HashMap<>();

      // 遍歷nums2的元素構建單調遞減棧，找每一個元素下一個更大的元素
      for (int num : nums2) {
          while (!stack.isEmpty() && stack.peek() < num) {
              map.put(stack.pop(), num);
          }
          stack.push(num);
      }

      // 將剩餘的元素（沒有找到更大右側的更大元素）處理為-1
      while (!stack.isEmpty()) {
          map.put(stack.pop(), -1);
      }

      // 根據哈希表獲取每個元素的下一個更大元素
      int[] res = new int[nums1.length];
      for (int i = 0; i < nums1.length; i++) {
          res[i] = map.get(nums1[i]);
      }
      return res;
  }
}

/**
 * 下一個更大元素 I：要求找到在數組nums1中每個元素在nums2中的下一個更大元素
 * nums1是nums2的子集，，對於nums1每個元素，需要在nums2中找到它右側的第一個更大的元素，如果不存在，則return -1
 * 
 * 這題可以用哈希表加單調遞減棧來解決，遍歷nums2的元素構建單調遞減棧，找每一個元素下一個更大的元素
 * 再用哈希表存儲每個元素的下一個更大元素，最後根據哈希表獲取每個元素的下一個更大元素來構建結果數組
 **/