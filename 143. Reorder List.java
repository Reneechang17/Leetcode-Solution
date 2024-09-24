// Medium
// LinkedList, Two Pointers
// O(n)
// https://leetcode.com/problems/reorder-list/

class Solution {
  public void reorderList(ListNode head) {
      ListNode fast = head, slow = head;
      while (fast.next != null && fast.next.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }

      ListNode cur = slow.next;
      slow.next = null;

      ListNode pre = null;
      while(cur != null) {
          ListNode t = cur.next;
          cur.next = pre;
          pre = cur;
          cur = t;
      }
      cur = head;

      while (pre != null) {
          ListNode t = pre.next;
          pre.next = cur.next;
          cur.next = pre;
          cur = pre.next;
          pre = t;
      }
  }
}

/**
 * 重排鏈表：將前半部分與後半部分交替連接
 * 
 * 思路：首先需要區分鏈表的前後半部分，這裡可以用快慢指針來定位鏈表的中點（慢指針每次一步，快指針每次兩步，最後慢指針指向中點）
 * 將鏈表的後半段反轉，用一個指針從後往前依次反轉指向上一個節點
 * 最後把這兩個鏈表交替合併，用兩個指針遍歷兩個子鏈表，每次交替插入一個節點
 **/