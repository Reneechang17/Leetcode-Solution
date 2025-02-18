// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/

class Solution {
    // BST' inorder -> sorted
    private int count = 0, ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if(count == k) {
            ans = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
