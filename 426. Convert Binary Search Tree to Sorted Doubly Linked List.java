// Medium
// Linked List
// Time:O(n), Space: O(h)
// https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

class Solution {
  private Node prev = null;
  private Node head = null;

  public Node treeToDoublyList(Node root) {
      if (root == null) return null;
      inorder(root);
      // 中序遍历完，把head和尾节点连接，形成循环链表
      // 1 <-> 2 <-> 3 <-> 5 <-> (back to 1)
      // prev = 5
      head.left = prev;
      prev.right = head;
      return head;
  }
  private void inorder(Node node) {
      if (node == null) return;
      inorder(node.left);
      
      if (prev == null) {
          // 代表这是第一个节点，将其作为头节点
          head = node;
      } else {
          prev.right = node;
          node.left = prev;
      }
      // update prev pointer
      prev = node;

      inorder(node.right);
  }
}
