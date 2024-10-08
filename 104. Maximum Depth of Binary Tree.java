// Easy
// BFS
// O(n)
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/

import java.util.*;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            while (len > 0) {
                TreeNode node = que.poll();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                len--;
            }
            depth++;
        }
        return depth;
    }
}

/**
 * 二叉樹的最大深度
 * 
 * 思路：這題的BFS比較直觀，透過一層一層遍歷記錄可以找到從根節點到葉子節點最深的層數
 * 也可以用DFS
 **/
