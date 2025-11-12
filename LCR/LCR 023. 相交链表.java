// Easy
// LinkedList
// Time:O(m+n),Space:O(1)
// https://leetcode.cn/problems/3u1WK4/

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;

        // calculate the len
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // make sure curA is longer one
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
        
        // let the longer one step further
        int gap = lenA - lenB;
        while (gap > 0) {
            curA = curA.next;
            gap--;
        }

        // find intersection
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
