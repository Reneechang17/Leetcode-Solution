// Medium
// BFS
// O(n)
// https://leetcode.cn/problems/find-largest-value-in-each-tree-row/

import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // 找每一層的最大值 -> BFS
        // 變量存儲最大值，在每一層紀錄更新，最後收集每一層的最大值到結果列表
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        
        que.offer(root);
        while (!que.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int n = que.size();
            for (int i = n; i > 0; i--) {
                TreeNode node = que.poll();
                max = Math.max(max, node.val);

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
