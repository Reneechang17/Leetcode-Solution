// Medium
// LinkedList, Two Pointers
// O(n)

class Solution {
   class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
  public ListNode detectCycle(ListNode head) {
      ListNode slow = head, fast = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
          if(slow == fast){
              ListNode idx1 = fast;
              ListNode idx2 = head;
              while(idx1 != idx2){
                  idx1 = idx1.next;
                  idx2 = idx2.next;
              }
              return idx1;
          }
      }
      return null;
  }
}
