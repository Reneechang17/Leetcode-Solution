// Easy
// LinkedList
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/intersection-of-two-linked-lists/

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;
        // calculate the len of two linkedlist and find diff
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // make sure curA as the longer one, if curB is longer, swap 
        curA = headA;
        curB = headB;
        if (lenB > lenA) {
            int tmp = lenA;
            lenA = lenB;
            lenB = tmp;
            ListNode tmpCur = curA;
            curA = curB;
            curB = tmpCur;
        }
        int gap = lenA - lenB;
        // let the longer one go 'gap' steps further
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }
        // find the intersection
        while (curA != null) {
            if (curA == curB) {
                return curA;
            } else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
}
