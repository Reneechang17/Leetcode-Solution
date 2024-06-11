// Easy
// LinkedList, Recursion
// O(n)
// https://leetcode.com/problems/remove-linked-list-elements/

class Solution {
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public ListNode removeElements(ListNode head, int val) {
      if(head == null) {
          return head;
      }

      ListNode dummy = new ListNode(-1, head);
      ListNode pre = dummy;
      ListNode cur = head;
      while(cur != null){
          if(cur.val == val){
              pre.next = cur.next;
          } else {
              pre = cur;
          }
          cur = cur.next;
      }
      return dummy.next;
  }
}

/**
 * 刪除鏈表中的節點：直接將欲刪除節點的前一個節點指向欲刪除節點的下一個節點
 * edge case：由於刪除的節點可能是頭節點，需要設dummy head
 **/