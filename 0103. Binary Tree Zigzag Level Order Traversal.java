// Medium
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

class Solution {
    // Use BFS level-order traversal with a flag to track zigzag order
    // Use a queue to process each level of the tree
    // At each level, if the flag is false, reverse the list before adding to results
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = true; // true:left to right, false:right to left
        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = que.poll();
                list.add(temp.val);
                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
            }
            if (!flag) {
                Collections.reverse(list);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }
}
