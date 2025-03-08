// Medium
// BST, Recursion
// Time:O(4^n / n^1/2),Space:O(n)
// https://leetcode.cn/problems/unique-binary-search-trees-ii/

import java.util.*;

class Solution {
    // For every node i, the left are 1~i-1, right are i+1~n
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        // Try every node as root;
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generate(start, i - 1);
            List<TreeNode> rights = generate(i + 1, end);
            // combine each left and right subtree with cur root
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
