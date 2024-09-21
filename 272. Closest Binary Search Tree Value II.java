// Hard
// BST, Deque
// O(n)
// https://leetcode.com/problems/closest-binary-search-tree-value-ii/

import java.util.*;

class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
      Deque<Integer> deq = new LinkedList<>();
      inorder (root, target, k, deq);
      return new ArrayList<>(deq);
  }

  private void inorder(TreeNode node, double target, int k, Deque<Integer> deq) {
      if (node == null) {
          return;
      }

      inorder(node.left, target, k, deq);

      if (deq.size() < k) {
          deq.addLast(node.val);
        } else {
          // 檢查當前節點是不是比deq中最遠的節點更接近target
        // 如果是，則將最遠的節點刪除，將當前節點加入
          if (Math.abs(node.val - target) < Math.abs(deq.peekFirst() - target)) {
              deq.pollFirst();
              deq.addLast(node.val);
          } else {
              return;
          }
      }
      inorder(node.right, target, k, deq);
  }
}

/**
 * 最接近的二叉樹值III：給定一個二叉搜索樹，找到距離目標值最近的k個節點
 *
 * 二叉搜索樹的特性就是左子樹的值都是小於根節點，而右子樹都大於根節點
 * 那麼可以通過中序遍歷來得到一個有序的節點列表，在遍歷的過程中，用一個雙向隊列來維護最近的k個節點，並實時更新
 **/