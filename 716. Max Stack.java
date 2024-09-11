// Hard
// DoblyLinkedList
// O(1) & O(logn)
// https://leetcode.com/problems/max-stack/

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
  TreeMap<Integer, List<Node>> map = new TreeMap<>();
  DoubleLinkedList dll = new DoubleLinkedList();

  public MaxStack() {
      
  }
  
  public void push(int x) {
      Node node = dll.add(x);
      map.putIfAbsent(x, new ArrayList<>());
      map.get(x).add(node);
  }
  
  public int pop() {
      int val = dll.pop();
      List<Node> list = map.get(val);
      list.remove(list.size() - 1);
      if (list.isEmpty()) map.remove(val);
      return val;
  }
  
  public int top() {
      return dll.peek();
  }
  
  public int peekMax() {
      return map.lastKey();
  }
  
  public int popMax() {
      int max = peekMax();
      List<Node> list = map.get(max);
      Node node = list.remove(list.size() - 1);
      dll.remove(node);
      if (list.isEmpty()) map.remove(max);
      return max;
  }

  class DoubleLinkedList {
      Node head, tail;
      
      public DoubleLinkedList() {
          head = new Node(0);
          tail = new Node(0);
          head.next = tail;
          tail.prev = head;
      }
      public Node add (int val) {
          Node node = new Node(val);
          node.next = tail;
          node.prev = tail.prev;
          tail.prev.next = node;
          tail.prev = node;
          return node;
      }
      public int pop() {
          return remove (tail.prev).val;
      }
      public int peek() {
          return tail.prev.val;
      }
      public Node remove (Node node) {
          node.prev.next = node.next;
          node.next.prev = node.prev;
          return node;
      }
  }

  class Node {
      int val;
      Node prev, next;
      Node (int v) {
          val = v;
      }
  }
}

/**
 * 最大棧：實現一個最大棧，支持push、pop、top、peekMax、popMax操作
 * 這題對時間複雜度有要求，要求push、pop、top操作的時間複雜度為O(1)，peekMax、popMax操作的時間複雜度為O(logn)
 * 也就是單純用棧是無法滿足要求的，需要用到其他數據結構（O(n))
 * 
 * 優化方法：使用TreeMap和雙向鏈表實現
 * 用雙向鏈表來存儲數據，用TreeMap來維護指向包含相同值的所有鏈表節點的指針列表
 **/