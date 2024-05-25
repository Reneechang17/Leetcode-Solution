// Medium
// LinkedList, Recursion
// O(n)

class Solution {
   public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
  public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode cur = dummy;
      ListNode temp;
      ListNode firstNode, secondNode;
      while(cur.next != null && cur.next.next != null){
          temp = cur.next.next.next; // use the temp to store the second node' next
          firstNode = cur.next;
          secondNode = cur.next.next;
          cur.next = secondNode;  // Step1: dummy point to the second node
          secondNode.next = firstNode; // Step2: second node point to the first node
          firstNode.next = temp; // Step3: first node point to the temp
          cur = firstNode; // then move forward cur to do the recursion
      }
      return dummy.next;
  }
}
