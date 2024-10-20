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
