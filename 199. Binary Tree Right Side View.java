// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/binary-tree-right-side-view/

import java.util.*;

class Solution {
    // Use BFS to collect the last node of each level
    // Use a queue to traverse each level and track the rightmost node
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // basecase: if the tree is empty
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                // add left and right child to que
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                // add last node of this level to res
                if (i == n - 1) res.add(node.val);
            }
        }
        return res;
    }
}
