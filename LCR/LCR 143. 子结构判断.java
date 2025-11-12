// Medium
// Tree, DFS
// Time:O(m*n), Space:O(h1+h2)
// https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/

class Solution {
    // Find a pos at A and insert B into it to check if it can be sub
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    // Check if the sub which use A as root, if it same as B
    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true; // iterate the end of B -> match
        if (A == null || A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
