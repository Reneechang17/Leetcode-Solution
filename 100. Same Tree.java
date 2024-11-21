// Easy
// DFS
// Time:O(n), Space:O(n)->worse case:a skewed tree, O(logn)->balanced tree
// https://leetcode.cn/problems/same-tree/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // use DFS to search two tree
        return compare(p, q);
    }

    private boolean compare(TreeNode p, TreeNode q) {
        // check null condition, if both are null -> True
        // if one of them is null -> False
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        } 

        // check value
        if (p.val != q.val) {
            return false;
        }

        boolean compareLeft = compare(p.left, q.left);
        boolean compareRight = compare(p.right, q.right);
        return compareLeft && compareRight;
    }
}
