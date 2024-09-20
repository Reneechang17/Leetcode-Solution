// Medium
// LinkedList, Hash table
// O(1)
// https://leetcode.com/problems/lru-cache/

import java.util.HashMap;

class LRUCache {
  private class Node {
      int key, value;
      Node prev, next;
      Node(int key, int value) {
          this.key = key;
          this.value = value;
      }
  }

  private int capacity;
  private HashMap<Integer, Node> map;
  private Node head, tail;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
  }
  
  public int get(int key) {
      if (!map.containsKey(key)) {
          return - 1;
      }
      Node node = map.get(key);
      moveToHead(node);
      return node.value;
  }
  
  public void put(int key, int value) {
      if (map.containsKey(key)) {
          Node node = map.get(key);
          node.value = value;
          moveToHead(node);
      } else {
          Node newNode = new Node(key, value);
          map.put(key, newNode);
          addToHead(newNode);
          if(map.size() > capacity) {
              Node tailNode = removeTail();
              map.remove(tailNode.key);
          }
      }
  }

  private void moveToHead(Node node) {
      removeNode(node);
      addToHead(node);
  }

  private void removeNode(Node node) {
    node.prev.next = node.next; // 前一個節點的next指針指向下一個節點
    node.next.prev = node.prev; // 下一個節點的prev指針指向前一個節點
  }
  // 將節點添加到鏈表頭部
  private void addToHead(Node node) {
      // 新加入節點的prev指向head節點（頭哨兵）
      node.prev = head;
      // 新節點的next節點指向原來的第一個節點（頭哨兵下一個）
      node.next = head.next;
      // 原本第一個節點的prev指向新節點
      head.next.prev = node;
      // 頭哨兵的next指向新節點
      head.next = node;
  }

  private Node removeTail() {
      // 找到最後一個節點，因為tail表示的是哨兵節點，所以真正的最後一個節點是tail.prev
      Node node = tail.prev;
      removeNode(node);
      return node;
  }
}

/**
 * 設計一個LRU緩存：其遵循最近最少使用的策略，當緩存機制滿了，則刪除最近最少使用的，並保證時間複雜度為O(1)
 * 需要實現get方法：如果緩存中存在key，則返回相對應的value，否則返回-1。每次訪問都需要將訪問的鍵值對標記為最近使用
 * put方法：如果緩存中存在key，則需要更新他的值；如果不存在，則插入新的，並檢查緩存是否已經滿了（超過容量），如果滿了，就刪除最近最少使用的鍵值對
 * 
 * 思路：首先這題要求在O(1)，就可以想到用哈希表，另外要刪除最少使用的，可以想到鏈表這個數據結構，在頭尾做刪減比較高效
 * 根據題目要求，可以發現我們需要四個輔助函數（主要處理鏈表Node的移動），分別是將節點挪到鏈表頭部（先移除節點再添加到頭部）、從鏈表中刪除節點、將節點添加到鏈表頭部、刪除鏈表結尾節點
 * 而get和put方法根據需求寫即可
 **/