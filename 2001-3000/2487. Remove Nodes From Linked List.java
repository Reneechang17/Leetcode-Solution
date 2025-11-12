// Medium
// LinkedList
// https://leetcode.cn/problems/remove-nodes-from-linked-list/

// Actually idk why I original write the way use two reverse, it's not make sense for current me LOL
// What I thought for now(9/4) is iterate from tail, or to say we use recursion to call the last node

class Solution {
    // Time:O(n), Space:O(n)
    public ListNode removeNodes(ListNode head) {
        // basecase
        if (head == null)
            return null;

        // use recursion to find the last node
        head.next = removeNodes(head.next);

        if (head.next != null && head.val < head.next.val) {
            return head.next;
        }
        return head;
    }
}

// ex. 5 - 2 - 13 - 3 - 8
// removeNodes(5)
// |- removeNodes(2)
//  |- removeNodes(13)
//   |- removeNodes(3)
//     |- removeNodes(8)
//       |- removeNodes(null) return null

// then start check if remove the node
// step1: head = 8, head.next = null -> return 8
// step2: head = 3, head.next = 8 -> remove 3 -> 13 - 8
// step3: head = 13, head.next = 8 -> remain 13 -> 13 - 8
// step4: head = 2, head.next = 13 -> remove 2 -> 13 - 8
// step5: head = 5, head.next = 13 -> remove 5 -> 13 - 8 <-- res


// Yeah and if we want to optimize space, we can use two reverse(or interviewer ask LOL)
// The way is reverse the linkedlist first, and we compare list[i]>list[i+1] -> remove list[i]
// Then finally reverse back

class Solution2 {
    // Time:O(n), Space:O(1)
    public ListNode reverseNodes(ListNode head) {
        head = reverse(head);
        ListNode cur = head;
        int curVal = cur.val;

        while (cur.next != null) {
            if (curVal > cur.next.val) {
                cur.next = cur.next.next; // remove
            } else {
                // remember to update curVal first then move
                curVal = cur.next.val;
                cur = cur.next;
            }
        }

        return reverse(head);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
