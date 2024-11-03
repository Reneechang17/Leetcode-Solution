// Easy
// BFS
// O(n)
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/

import java.util.*;

class Solution {
    // use the bfs to calculate the depth -> Queue
    // when we do the bfs, also need to check if the cur node has child
    // if it has child, add to queue
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            
            while (n > 0) {
                TreeNode tmp = que.poll();
                if (tmp.left != null) {
                    que.offer(tmp.left);
                }

                if (tmp.right != null) {
                    que.offer(tmp.right);
                }
                n--;
            }
            depth++;
        }
        return depth;
    }
}
