// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/

import java.util.*;

class Solution {
    // BFS to traverse each level
    public Node connect(Node root) {
        // basecase
        if (root == null) return null;

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int n = que.size();
            Node prev = null;

            for (int i = 0; i < n; i++) {
                Node cur = que.poll();

                // Link the prev node to cur node
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;

                // add the child of cur node to que
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            // the last node of each level should point to null
            prev.next = null;
        }
        return root;
    }
}

// Initialize add root node to que = [1]
// Level 1: process node 1
//          prev = null(initially), set prev = 1
//          Add left and right child to que = [2, 3], set prev.next = null => 1 -> #
// Level 2: process node 2, set prev = 2, add left and right child to que = [3, 4, 5] 
//          process node 3, link prev.next = 3, add child to que = [4, 5, 7], set null => 2 -> 3 -> #
// Level 3: process node 4, set prev = 4, no child add to que
//          process node 5, link prev.next = 5, prev = 5, no child add to que
//          process node 7, link prev.next = 7, prev = 7, no child add to que
//          set null => 4 -> 5 -> 7 -> #
