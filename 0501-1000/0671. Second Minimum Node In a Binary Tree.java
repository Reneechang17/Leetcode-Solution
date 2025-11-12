// Easy
// Recursion
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        // empty tree or only one node in tree
        if (root == null || (root.left == null && root.right == null)) return -1;

        int rootVal = root.val; // the min node is root node

        // find second min node in left tree
        int leftSecMin;
        if (root.left.val == rootVal) {
            leftSecMin = findSecondMinimumValue(root.left);
        } else {
            leftSecMin = root.left.val;
        }

        // find second min node in right tree
        int rightSecMin;
        if (root.right.val == rootVal) {
            rightSecMin = findSecondMinimumValue(root.right);
        } else {
            rightSecMin = root.right.val;
        }

        if (leftSecMin == -1) {
            return rightSecMin;
        }
        if (rightSecMin == -1) {
            return leftSecMin;
        }

        return Math.min(leftSecMin, rightSecMin);
    }
}
