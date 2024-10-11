// Medium
// Tree
// O(n)
// https://leetcode.cn/problems/binary-tree-level-order-traversal/

import java.util.*;

class Solution {
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return res;
    }

    public void bfs(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = que.size();

            while (n > 0) {
                TreeNode temp = que.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    que.offer(temp.left);
                }

                if (temp.right != null) {
                    que.offer(temp.right);
                }
                n--;
            }
            res.add(list);
        }
    }
}

/**
 * 這題是二叉樹的層序遍歷，可以用BFS來完成
 **/
