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
