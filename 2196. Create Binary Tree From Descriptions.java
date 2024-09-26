// Medium
// Hash Table
// O(n)
// https://leetcode.com/problems/create-binary-tree-from-descriptions/

import java.util.*;

class Solution {
  public TreeNode createBinaryTree(int[][] descriptions) {
      Map<Integer, TreeNode> map = new HashMap<>();
      Set<Integer> set = new HashSet<>();

      for (int[] description : descriptions) {
          TreeNode parent = map.getOrDefault(description[0], new TreeNode(description[0]));
          TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));
          if (description[2] == 1) {
              parent.left = child;
          } else {
              parent.right = child;
          }
          if (!map.containsKey(description[1])) map.put(description[1], child);
          if (!map.containsKey(description[0])) map.put(description[0], parent);
          set.add(description[1]); 
      }

      for (int key : map.keySet()) {
          if (!set.contains(key)) {
              return map.get(key); // 他是root
          }
      }
      return null;
  }
}

/**
 * 從描述中創建二叉樹：給定一個二維數組描述，每個元素是一個三元組[parent, child, isLeft]
 * 這題可以用哈希表來做，key存元素的值，value存對應的節點，將它對應的parent和child加進來，然後判斷是左邊還是右邊
 * 最後遍歷一遍map，找到root節點
 **/