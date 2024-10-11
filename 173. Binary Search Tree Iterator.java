// Medium
// Binary Search Tree
// https://leetcode.cn/problems/binary-search-tree-iterator/

import java.util.*;

class BSTIterator {
    // 中序 -> left-root-right
    private int cur = 0;
    private List<Integer> vals = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        return vals.get(cur++); // 返回當前cur的元素，再將cur+1
    }
    
    public boolean hasNext() {
        return cur < vals.size();
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            vals.add(root.val);
            inorder(root.right);
        }
    }
}

/**
 * 實現一個中序遍歷的二叉搜索樹迭代器類
 * 1. BSTIterator(TreeNode root)：初始化一個BSTIterator類的對象。根節點會作為構造函數的一個部分。指針的初始化為一個不存在BST中的數字，且該數字小於BST中任何元素
 * 2. boolean hasNext()：如果指針向右遍歷還存在數字，則返回true（也就是他還沒reach到盡頭時）
 * 3. int next()：將指針向右移動，返回指針處的數字
 **/
