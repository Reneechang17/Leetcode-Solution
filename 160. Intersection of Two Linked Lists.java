// Easy
// LinkedList, Two Pointers
// O(n + m)

class Solution {
  public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
   }
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      ListNode curA = headA;
      ListNode curB = headB;
      int lenA = 0, lenB =0;
      // find gap of two linkedlist
      while(curA != null){
          lenA++;
          curA = curA.next;
      }
      while(curB != null){
          lenB++;
          curB = curB.next;
      }
      // keep the curA be the longer one
      curA = headA;
      curB = headB;
      // if lenB is longer, then swap them
      if(lenB > lenA){
          int tempLen = lenA;
          lenA = lenB;
          lenB = tempLen;

          ListNode tempCur = curA;
          curA = curB;
          curB = tempCur;
      }
      int gap = lenA - lenB;
      // the longer one go first with gap numebr steps
      while(gap > 0){
          curA = curA.next;
          gap--;
      }
      // find the intersection
      while(curA != null){
          if(curA == curB){
              return curA;
          } else {
              curA = curA.next;
              curB = curB.next;
          }
      }
      return null;
  }
}