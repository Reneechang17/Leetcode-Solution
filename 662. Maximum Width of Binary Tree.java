// Medium
// BFS
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/maximum-width-of-binary-tree/

import java.util.*;

class Solution {
  // Assign index to each node: root=0, left=2*parent_index, right=2*parent_index+1
  // BFS track leftmost and rightmost index -> width=right_index-left_index+1
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    int maxWidth = 0;
    Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
    que.offer(new Pair<>(root, 0));
    while (!que.isEmpty()) {
      int n = que.size();
      int leftIndex = que.peek().getValue();
      int rightIndex = leftIndex;
      for (int i = 0; i < n; i++) {
        Pair<TreeNode, Integer> pair = que.poll();
        TreeNode node = pair.getKey();
        int index = pair.getValue();
        rightIndex = index;
        if (node.left != null) {
          que.offer(new Pair<>(node.left, 2 * index));
        }
        if (node.right != null) {
          que.offer(new Pair<>(node.right, 2 * index + 1));
        }
      }
      maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
    }
    return maxWidth;
  }
}

class Pair<K, V> {
  public K key;
  public V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }
}
