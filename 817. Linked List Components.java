// Medium
// Array, Hash Table, LinkedList
// O(m + n)
// https://leetcode.com/problems/linked-list-components/

import java.util.HashSet;
import java.util.Set;

class Solution {
  public int numComponents(ListNode head, int[] nums) {
      int ans = 0;
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
          set.add(num);
      }

      while (head != null) {
          // 當前不在數組中
          while (head != null && !set.contains(head.val)) {
              head = head.next;
          }
          ans += head != null ? 1 : 0;
          while (head != null && set.contains(head.val)) {
              head = head.next;
          }
      }
      return ans;
  }
}

/**
 * 給定鏈表頭節點head，該鏈表上的每個節點都有一個唯一的整型值。同時給定一個列表nums，這個列表是上述鏈表中整型值的一個子集
 * 返回列表nums中組件的個數，這裡組件的定義為：鏈表中一段最長連續節點的值（必須在nums中）構成的集合
 * 
 * 這題是要判斷鏈表中節點的值是否在數組nums中，可以用hashset來存儲nums中的值
 * 然後遍歷列表，找到第一個在哈希表中的節點，然後從該節點開始遍歷，直到遇到不在哈希表中的節點，這樣就找到一個組件
 * 接著繼續遍歷鏈表，直到遍歷完整個鏈表
 **/