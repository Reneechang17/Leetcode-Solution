// Medium
// Hash Table
// O(n)
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

import java.util.*;

class Solution {
  public Node lowestCommonAncestor(Node p, Node q) {
      Set<Node> visited = new HashSet<>();
      for (Node node = p; node != null; node = node.parent) {
          visited.add(node);
      }
      for (Node node = q;; node = node.parent) {
          if (!visited.add(node)) {
              return node;
          }
      }
  }
}

/**
 * 二叉樹的最近公共祖先III
 * 可以先看下235、236兩題，並且了解公共祖先的定義
 * 這題和前序題目不同在於，這裡給定的二叉樹，每個節點都有一個指向父節點的指針，但是沒有給定根節點
 * 因為這題有給指向父節點的指針，我們不需要從根節點開始往下遍歷，而是透過指向父節點的指針從下往上遍歷即可
 * （類似鏈表從每個節點回溯到他的根部，也就是到node.parent)
 * 
 * 解題思路：分別遍歷從p和q節點回溯到他們父節點，並用一個set來紀錄遍歷p時走過的節點，如果在遍歷q時遇到他的話，那麼這個節點就是p和q的最近公共祖先
 **/