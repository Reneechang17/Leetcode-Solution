// Easy
// BFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/

import java.util.*;
class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int n = que.size();
            while (n-- > 0) {
                Node node = que.poll();
                for (int i = 0; i < node.children.size(); i++) {
                    if (node.children.get(i) != null) {
                        que.offer(node.children.get(i));
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
