// Medium
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
  public ListNode swapNodes(ListNode head, int k) {
      ListNode first = head, second = head;
      ListNode cur = head;

      // use cur to find k
      for(int i = 1; i < k; i++){
          cur = cur.next; // now, cur point to k
      }
      first = cur; 

      // find the k from end: cur keep going til end and second join
      // At the end, the second point to the k from the end
      while(cur.next != null){
          cur = cur.next;
          second = second.next; 
      }

      // swap two value
      int temp = first.val;
      first.val = second.val;
      second.val = temp;

      return head;
  }
}
