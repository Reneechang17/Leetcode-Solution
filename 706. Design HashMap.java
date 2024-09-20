// Easy
// Hash Table, Design, Array
// O(1)
// https://leetcode.com/problems/design-hashmap/

import java.util.Arrays;

class MyHashMap {
  private int[] array = new int[1000001];

  public MyHashMap() {
      Arrays.fill(array, -1);
  }
  
  public void put(int key, int value) {
      array[key] = value;
  }
  
  public int get(int key) {
      return array[key];
  }
  
  public void remove(int key) {
      array[key] = -1;
  }
}

/**
 * 設計一個簡單的哈希表：支持put，get和remove操作
 * 
 * 寫這題需要知道哈希表的核心思想，即通過哈希函數將key映射到數組的索引位置，從而實現快速查找、插入和刪除（O(1)）
 * 這題只需要做簡單的映射就可以了，因為他的數據量不算大，所以開簡單且固定大小的數據就可以滿足需求
 *  **/