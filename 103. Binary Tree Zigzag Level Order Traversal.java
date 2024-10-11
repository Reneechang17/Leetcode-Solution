// Medium
// BFS
// O(n)
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean left = true; // true -> left to right; false -> right to left

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

            if (!left) {
                Collections.reverse(list); // right -> left
            }

            res.add(list);
            left = !left;
        }
        return res;
    }
}

/**
 * 對於ZIGZAG，需要在層序遍歷的基礎上加上一個標誌flag，用於標記當前遍歷層遍歷的順序（true為左到右，false為右到左）
 * BFS的過程也要check一下遍歷的順序，如果是從右到左，則需要對list進行reverse操作
 **/
