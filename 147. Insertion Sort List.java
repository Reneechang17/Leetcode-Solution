// Medium
// Insertion Sort, Linked List
// O(n^2)
// https://leetcode.cn/problems/insertion-sort-list/

class Solution {
  public ListNode insertionSortList(ListNode head) {
      ListNode dummy = new ListNode(-1);
      ListNode cur = head;

      while (cur != null) {
          ListNode next = cur.next;

          ListNode prev = dummy;
          while (prev.next != null && prev.next.val < cur.val) {
              prev = prev.next;
          }

          cur.next = prev.next;
          prev.next = cur;

          cur = next;
      }
      return dummy.next;
  }
}

/**
 * 插入排序：對鏈表進行插入排序 
 * 
 * 遍歷整個鏈表，並將每個節點插入到一個已經排序好的鏈表中
 * 對於每個沒有排序的節點，從頭開始遍歷已經排序好的部分，找到適合的位置加入
 **/