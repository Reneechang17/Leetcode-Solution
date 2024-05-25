// Easy
// LinkedList, Two Pointers
// O(n)

class Solution {
    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
  public boolean isPalindrome(ListNode head) {
      ListNode slow = head, fast = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
      }

      if(fast != null){
          slow = slow.next;
      }

      ListNode first = head;
      ListNode second = reverse(slow);
      while(second != null){
          if(first.val != second.val){
              return false;
          } else {
              first = first.next;
              second = second.next;
          }
      }
      return true;
  }

  ListNode reverse(ListNode head){
      ListNode pre = null, cur = head;
      while(cur != null){
          ListNode curNext = cur.next;
          cur.next = pre;
          pre = cur;
          cur = curNext;
      }
      return pre;
  }
}