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
            int n = que.size();

            while (n > 0) {
                TreeNode temp = que.poll();
                if (temp.left != null) {
                    que.offer(temp.left);
                }

                if (temp.right != null) {
                    que.offer(temp.right);
                }
                n--;
            }
            depth++;
        }
        return depth;
    }
}

/**
 * 二叉樹的最大深度
 * BFS的過程紀錄深度，最後返回深度即可，DFS也可以做
 **/
