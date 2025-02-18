// Hard
// Hash Table, Linked List
// https://leetcode.com/problems/all-oone-data-structure/

import java.util.*;

class AllOne {
  Node root = new Node();
  Map<String, Node> map = new HashMap<>();

  public AllOne() {
      root.next = root;
      root.prev = root;
  }
  
  public void inc(String key) {
      if(!map.containsKey(key)) {
          if (root.next == root || root.next.count > 1) {
              map.put(key, root.insert(new Node(key, 1)));
          } else {
              root.next.keys.add(key);
              map.put(key, root.next);
          }
      } else {
          Node cur = map.get(key);
          Node next = cur.next;
          if (next == root || next.count > cur.count + 1) {
              map.put(key, cur.insert(new Node(key, cur.count + 1)));
          } else {
              next.keys.add(key);
              map.put(key, next);
          }
          cur.keys.remove(key);
          if (cur.keys.isEmpty()) {
              cur.remove();
          }
      }
  }
  
  public void dec(String key) {
      Node cur = map.get(key);
      if (cur.count == 1) {
          map.remove(key);
      } else {
          Node prev = cur.prev;
          if (prev == root || prev.count < cur.count - 1) {
              map.put(key, prev.insert(new Node(key, cur.count - 1)));
          } else {
              prev.keys.add(key);
              map.put(key, prev);
          }
      }
      cur.keys.remove(key);
      if (cur.keys.isEmpty()) {
          cur.remove();
      }
  }
  
  public String getMaxKey() {
      return root.prev.keys.iterator().next();
  }
  
  public String getMinKey() {
      return root.next.keys.iterator().next();
  }
}

class Node {
  Node prev, next;
  int count;
  Set<String> keys = new HashSet<>();

  public Node() { this("", 0);}

  public Node (String key, int count) {
      this.count = count;
      keys.add(key);
  }

  public Node insert(Node node) {
      node.prev = this;
      node.next = this.next;
      node.prev.next = node;
      node.next.prev = node;
      return node;
  }

  public void remove() {
      this.prev.next = this.next;
      this.next.prev = this.prev;
  }
}
