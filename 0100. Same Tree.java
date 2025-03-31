// Easy
// DFS
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/same-tree/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
    private boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return compare(p.left, q.left) && compare(p.right, q.right);
    }
}
