// Easy
// LinkedList
// O(n)
// https://leetcode.com/problems/reverse-linked-list/

class Solution {
  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode reverseList(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode temp;

    while (cur != null) {
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }
}

/**
 * 反轉鏈表核心：改變指針指的方向
 * Note：需要一個temp來先紀錄當前節點的下一個節點，避免之後覆蓋
 **/