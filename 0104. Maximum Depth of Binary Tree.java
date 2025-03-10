// Easy
// BFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/maximum-depth-of-binary-tree/

import java.util.*;
class Solution {
    // Use BFS to calculate depth -> Queue
    // When we do the bfs, also need to check if the cur node has child
    //   - if it has child, add to queue
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = que.poll();
                if (tmp.left != null) que.offer(tmp.left);
                if (tmp.right != null) que.offer(tmp.right);
            }
            depth++;
        }
        return depth;
    }
}

// que = [3], depth = 0
// first level: tmp = 3, que = [9, 20], depth = 1
// second level: tmp = 9, que = []
//               tmp = 20, que = [15, 7], depth = 2
// third level: tmp = 15, que = []
//              tmp = 7, que = [], depth = 3  
