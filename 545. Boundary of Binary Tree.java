// Medium
// Tree, DFS
// O(n)
// https://leetcode.com/problems/boundary-of-binary-tree/

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>(1000);

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return res;
    }

    private void leftBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        res.add(root.val);
        if (root.left == null)
            leftBoundary(root.right);
        else
            leftBoundary(root.left);
    }

    private void rightBoundary(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        if (root.right == null)
            rightBoundary(root.left);
        else
            rightBoundary(root.right);
        res.add(root.val); // behind the recursion to make sure add them after root.val to ensure reverse order
    }

    private void leaves(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}

/**
 * 題目：這題要求計算一個給定二叉樹的邊界，邊界由以下組成：
 * 1. 根節點到最左側節點的路徑（不包含葉子節點，除非根節點是葉子節點）
 * 2. 所有從左到右的葉子節點
 * 3. 最右側大根節點的路徑（逆序，不包含葉子節點和根節點）
 * 
 * 思路：
 * 1. 確定左邊界：從根節點，如果有左子樹就向左移動，沒有左子樹但有右子樹就向右移動，直到遇到葉子節點）
 * 2. 確定葉子節點：用DFS遍歷整個樹，收集葉子節點
 * 3. 確定右邊界：從根節點向右子樹移動（類似確定左邊界的作法），最後將這部分的路徑逆序，確保其由下往上遍歷的順序
 * => 將以上合併
 **/