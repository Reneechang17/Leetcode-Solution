// Easy
// BFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/average-of-levels-in-binary-tree/

import java.util.*;

class Solution {
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        // basecase
        if (root == null) return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (!que.isEmpty()) {
            int n = que.size();
            double sum = 0.0;

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                sum += node.val;

                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(sum / n);
        }
        return res;
    }
}
