// Hard
// LinkedList
// Time:O(n), Space:O(n/k)
// https://leetcode.cn/problems/reverse-nodes-in-k-group/

class Solution{
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;

        // 找区间
        ListNode start = head, end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) return head;
            end = end.next;
        }

        // 反转区间: 返回反转后的头节点
        ListNode newHead = reverse(start, end);
        
        // 和原本的接上：原本的结尾和前一段的最后一个接上
        start.next = reverseKGroup(end, k);
        return newHead;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre, cur, next;
        pre = null;
        cur = start;
        next = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre; // 反转当前节点的指针
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
