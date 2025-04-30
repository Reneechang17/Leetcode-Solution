// Medium
// HashMap
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/copy-list-with-random-pointer/


// class Solution {
//   public Node copyRandomList(Node head) {
//       if (head == null) return null;
//       Map<Node, Node> map = new HashMap<>();
//       Node cur = head;

//       // First pass: copy nodes and store mapping
//       while (cur != null) {
//           map.put(cur, new Node(cur.val));
//           cur = cur.next;
//       }

//       // Second pass: set next and random pointers
//       cur = head;
//       while (cur != null) {
//           map.get(cur).next = map.get(cur.next);
//           map.get(cur).random = map.get(cur.random);
//           cur = cur.next;
//       }
//       return map.get(head);
//   }
// }
