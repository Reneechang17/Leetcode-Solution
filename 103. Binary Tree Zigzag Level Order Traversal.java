// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root);
        return res;
    }

    public void bfs(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);
        boolean flag = true; // true: left to right; flase: right to left

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
            if (!flag) {
                Collections.reverse(list);
            }

            res.add(list);
            flag = !flag;
        }
    }
}
