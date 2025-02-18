// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/binary-tree-level-order-traversal/

import java.util.*;

class Solution {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return res;
    }

    public void bfs(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    que.offer(temp.left);
                }

                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }
            res.add(list);
        }
    }
}
