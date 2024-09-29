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

/**
 * 思路：讓快慢指針中間有n個距離,通過確定相對位置來定位刪除節點的前一個節點
 * 1. 先讓快指針走到n+1的位置
 * 2. 慢指針加入，當快指針走到結尾，慢指針此時指向要刪除前的一個節點
 * 3. 將慢指針指向next.next達成刪除節點
 **/