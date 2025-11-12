// Medium
// BFS
// O(n)
// https://leetcode.cn/problems/find-bottom-left-tree-value/

import java.util.*;

class Solution {
    // goal:找這個樹最左下角的值並返回值
    // DFS和BFS應該都適用，這題可以考慮用BFS，因為每一層的第一個節點就是最左邊的值
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int res = 0;

        while (!que.isEmpty()) {
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                if (i == 0) res = node.val;

                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return res;
    }
}
