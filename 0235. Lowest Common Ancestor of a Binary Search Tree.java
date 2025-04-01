// Medium
// DFS
// Time:O(n),Space:O(h)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both left and right subtrees find the target -> cur node is LCA
        if (left != null && right != null) return root;
        // or return non-null side
        return left != null ? left : right;
    }
}

// 優化：BST中序排序是有序數組，代表這個節點一定在[p,q]之間，也就是從上到下遍歷中第一個遇到在這個區間的節點就是LCA
// Time:O(h),Space:O(1)

class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if cur > p&q -> find left
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
