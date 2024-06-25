// Medium
// Tree, Recursion
// https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.ArrayList;
import java.util.List;

class BSTIterator {
  private int cur = 0;
  private List<Integer> vals = new ArrayList<>();

  public BSTIterator(TreeNode root) {
      inorder (root);
  }
  
  public int next() {
      return vals.get(cur++);
  }
  
  public boolean hasNext() {
      return cur < vals.size();
  }

  private void inorder (TreeNode root) {
      if (root != null) {
          inorder (root.left);
          vals.add(root.val);
          inorder (root.right);
      }
  }
}

/**
 * 這題可能需要了解一下迭代器
 * 代碼很基礎，但是理解比較難
 * 
 * 這題是要實現一個中序遍歷的二叉搜索樹迭代器類
 * 1. BSTIterator(TreeNode root)：初始化一個BSTIterator類的對象。根節點會作為構造函數的一個部分。指針的初始化為一個不存在BST中的數字，且該數字小於BST中任何元素
 * 2. boolean hasNext()：如果指針向右遍歷還存在數字，則返回true（也就是他還沒reach到盡頭時）
 * 3. int next()：將指針向右移動，返回指針處的數字
 * 
 * 思路：這題可以使用遞歸操作，初始化數據的時候，用inorder遍歷每一個節點並把值存放在列表vals中。、
 * 用cur指針紀錄外部即將遍歷到的位置，初始化為0
 * 調用next指針時，返回的應該是vals[cur]，並且cur自增
 * 而hasNext則是判斷cur是否已經到vals長度的盡頭，如果到了，代表遍歷結束，返回false
 **/