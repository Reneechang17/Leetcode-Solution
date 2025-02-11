// Medium
// DFS
// Time:O(n),Stack:O(n)
// https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/

class Solution {
    // Use DFS to recursively flatten child lists first
    // Connect the child list to cur.next
    // Keep track the tail to properly reconnect next
    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        return head;
    }
    private Node dfs(Node node) {
        Node cur = node, tail = node;
        while (cur != null) {
            Node next = cur.next; // record the next first
            if (cur.child != null) {
                Node child = dfs(cur.child);

                // connect cur.child -> cur.next
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null; // cut child

                if (next != null) {
                    child.next = next;
                    next.prev = child;
                }
                tail = child; // update tail
            } else {
                // if no child with cur
                tail = cur;
            }
            cur = next;
        }
        return tail;
    }
}
