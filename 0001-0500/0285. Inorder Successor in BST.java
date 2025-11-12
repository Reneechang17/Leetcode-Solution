// Medium
// BST,DFS
// Time:O(h),Space:O(1)
// https://leetcode.cn/problems/inorder-successor-in-bst/

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // case1: if p has right subtree, 
        // successor is most left node in right subtree
        if (p.right != null) {
            p = p.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        // case2: if p has no right subtree,
        // we need to search its parent node(trace upward)
        TreeNode s = null;
        while (root != null) {
            if (p.val < root.val) {
                s = root;
                root = root.left;
            } else if (p.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return s;
    }
}
