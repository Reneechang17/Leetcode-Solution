// Medium
// LinkedList, Two Pointers
// O(n)

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
     
  public ListNode rotateRight(ListNode head, int k) {
      if(head == null || head.next == null){
          return head;
      }
      ListNode cur = head;
      int n = 0;
      for(; cur != null; cur = cur.next){
          n++;
      }
      k %= n;
      if(k == 0){
          return head;
      }
      ListNode fast = head, slow = head;
      // let fast go ahead with k steps
      while (k > 0) {
        fast = fast.next;
        k--;
    }
      while(fast.next != null){
          fast = fast.next;
          slow = slow.next;
      }
      ListNode ans = slow.next;
      slow.next = null;
      fast.next = head;
      return ans;
  }
}
