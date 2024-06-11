// Easy
// LinkedList, Two Pointers
// O(m + n)
// https://leetcode.com/problems/intersection-of-two-linked-lists/

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
      int lenA = 0, lenB = 0;
      
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

/**
 * 思路：
 * 1. 考慮兩條鏈表長度可能不一樣，需要先找長的 & 它們的長度差gap(lenA - lenB)
 * Note: 可以keep長的那條當A(如果B比較長，就讓AB交換一下)
 * 2. 先讓長的那條(A)先走gap步
 * Note: 這樣兩條鏈表剩下到結尾的長度是相同的
 * 3. 找intersection(看curA是否等於curB)
 **/