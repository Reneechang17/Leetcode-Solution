// Medium
// DFS, Counting
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

class Solution {
    private int count = 0, res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            res = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
