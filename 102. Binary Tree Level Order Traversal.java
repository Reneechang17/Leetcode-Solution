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
            List<Integer> list = new ArrayList<Integer>();
            int n = que.size();

            while (n > 0) {
                TreeNode tempNode = que.poll();
                list.add(tempNode.val);

                if (tempNode.left != null) {
                    que.offer(tempNode.left);
                }

                if (tempNode.right != null) {
                    que.offer(tempNode.right);
                }
                n--;
            }
            res.add(list);
        }
    }
}

/**
 * 這題是二叉樹的層序遍歷
 * 
 * review：層序遍歷是一種BFS，可以用隊列輔助完成（棧比較適合用於DFS）
 * 對於BFS，我們可以先遍歷根節點，再遍歷根節點的子節點，接著遍歷這些子節點的子節點
 **/