// Medium
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public List<List<Integer>> resList = new ArrayList<List<Integer>>();

  public List<List<Integer>> levelOrder(TreeNode root) {
      checkFunc(root);
      return resList;
  }

  public void checkFunc (TreeNode node) {
      if (node == null) return;

      Queue<TreeNode> que = new LinkedList<TreeNode>();
      que.offer(node);

      while (!que.isEmpty()) {
          List<Integer> itemList = new ArrayList<Integer>();
          int len = que.size();

          while (len > 0) {
              TreeNode tempNode = que.poll();
              itemList.add(tempNode.val);

              if (tempNode.left != null) {
                  que.offer(tempNode.left);
              }

              if (tempNode.right != null) {
                  que.offer(tempNode.right);
              }
              len--;
          }
          resList.add(itemList);
      }
  }
}

/**
 * 這題是二叉樹的層序遍歷
 * 
 * review：層序遍歷是一種BFS，可以用隊列輔助完成（棧比較適合用於DFS）
 * 對於BFS，我們可以先遍歷根節點，再遍歷根節點的子節點，接著遍歷這些子節點的子節點
 **/