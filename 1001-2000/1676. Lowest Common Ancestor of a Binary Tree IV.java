// Medium
// Set
// Time:O(n), Space:O(k)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv/

import java.util.*;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }
        return dfs(root, set);
    }
    private TreeNode dfs(TreeNode root, Set<TreeNode> set) {
        if (root == null) return null;
        if (set.contains(root)) return root;
        TreeNode left = dfs(root.left, set), right = dfs(root.right, set);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
