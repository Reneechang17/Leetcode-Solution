// Medium
// Tree
// O(n)
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();

      if (root == null) {
          return res;
      }

      Deque<TreeNode> que = new ArrayDeque<>();
      que.offer(root);
      boolean left = true;

      while (!que.isEmpty()) {
          List<Integer> itemList = new ArrayList<>();
          for (int n = que.size(); n > 0; n--) {
              TreeNode node = que.poll();
              itemList.add(node.val);
              if (node.left != null) {
                  que.offer(node.left);
              }
              if (node.right != null) {
                  que.offer(node.right);
              }
          }
          if (!left) {
              Collections.reverse(itemList);
          }
          res.add(itemList);
          left = !left;
      }
      return res;
  }
}

/**
 * 對於ZIGZAG，需要在層序遍歷的基礎上加上一個標誌flag，用於標記當前遍歷層遍歷的順序（true為左到右，false為右到左）
 * 
 * 核心遍歷邏輯：先check根節點是否為空，如果不為空則將根節點加入隊列中
 * 使用while循環處理隊列中的每一層，並初始化一個列表itemList存儲當前層的節點值
 * 
 * 處理完當前層後，先檢查left標誌，如果left為false，則將當前層的itemList反轉
 * 再更新left
 **/