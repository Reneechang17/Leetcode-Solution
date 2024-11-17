// Medium
// Linked List
// Time: O(n), Space: O(n)
// https://leetcode.cn/problems/copy-list-with-random-pointer/

import java.util.*;

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null)
      return null;

    Map<Node, Node> map = new HashMap<>();

    // 复制所有节点到哈希表
    Node cur = head;
    while (cur != null) {
      map.put(cur, new Node(cur.val));
      cur = cur.next;
    }

    // 再遍历一次，设置next和random指针
    cur = head;
    while (cur != null) {
      map.get(cur).next = map.get(cur.next);
      map.get(cur).random = map.get(cur.random);
      cur = cur.next;
    }

    // 返回新链表的头节点
    return map.get(head);
  }
}
