// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/binary-tree-right-side-view/

import java.util.*;

class Solution {
    // BFS to collect the last node in current level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // basecase
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.add(node.left);
                } 
                if (node.right != null) {
                    que.add(node.right);
                }

                // collect the last node
                if (i == n - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
