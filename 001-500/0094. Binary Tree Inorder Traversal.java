// Easy
// DFS, BFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/binary-tree-inorder-traversal/

import java.util.*;

class Solution {
    // DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

class Solution2 {
    // BFS
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // iterate leftmost node
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);

            cur = cur.right;
        }
        return res;
    }
}
