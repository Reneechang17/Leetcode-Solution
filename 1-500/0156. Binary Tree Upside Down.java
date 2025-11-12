// Medium
// Recursion
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/binary-tree-upside-down/

// This is a tricky recursion but not too hard to come about
// We can see after upside down, the left build would be the new root
// Origin root would be the right child, and origin right child would be the left child
// (see the description diagram would be pretty helpful:>)

class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // basecase 
        if (root == null || root.left == null)
            return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.right = root;
        root.left.left = root.right;

        // clean up origin root's left/right child
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
