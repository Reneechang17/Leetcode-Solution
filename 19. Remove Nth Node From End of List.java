// Easy
// LinkedList, Two Pointers
// O(n)
// https://leetcode.cn/problems/remove-nth-node-from-end-of-list/

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

    // 定义快慢指针，初始都从dummy节点开始，先让快指针走n步
    // 再让快慢指针一起走，指导快指针走到null
    // 这时候慢指针停的位置，就是要删除节点的前一个，可以直接让这个节点的next指针，指向下下一个
    // 从而删除了目标节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
