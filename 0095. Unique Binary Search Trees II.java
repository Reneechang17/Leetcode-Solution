// Medium
// Divide and Conquer
// Time:O(n * C(n)),Space:O(n * C(n))
// https://leetcode.cn/problems/unique-binary-search-trees-ii/

import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        // For every node i, the left are start~i-1, right are i+1~end
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }
    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        // try every node as root
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTree(start, i - 1);
            List<TreeNode> rightTrees = generateTree(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
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
