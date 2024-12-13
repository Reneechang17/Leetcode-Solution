// Medium
// HashMap, LinkedList
// Time: O(n), Space: O(n)
// https://leetcode.cn/problems/copy-list-with-random-pointer/

import java.util.*;

// Definition for a Node.
class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

class Solution {
  // Use HashMap to store the relationship between original linkedlist and new one
  // First round to deal with each node, and second round is to set the next and random pointers
  // Finally use map to get the head of new linkedlist
  public Node copyRandomList(Node head) {
      // basecase
      if (head == null) return null;
      // copy all the node to map
      Map<Node, Node> map = new HashMap<>();
      Node cur = head;
      while (cur != null) {
          map.put(cur, new Node(cur.val));
          cur = cur.next;
      }
      // iterate again, and set the next and random pointers
      cur = head;
      while (cur != null) {
          map.get(cur).next = map.get(cur.next);
          map.get(cur).random = map.get(cur.random);
          cur = cur.next;
      }
      // return the head of new linkedlist
      return map.get(head);
  }
}
