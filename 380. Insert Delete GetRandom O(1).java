// Medium
// Hash Table, Random
// O(1)
// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.*;

class RandomizedSet {
  private Map<Integer, Integer> map;
  private List<Integer> list;
  private Random random;

  public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
      random = new Random();
  }
  
  public boolean insert(int val) {
      if (map.containsKey(val)) {
          return false;
      }
      map.put(val, list.size());
      list.add(val);
      return true;
  }
  
  public boolean remove(int val) {
      if (!map.containsKey(val)) {
          return false;
      }
      int index = map.get(val);
      int lastElement = list.get(list.size() - 1);

      list.set(index, lastElement);
      map.put(lastElement, index);

      list.remove(list.size() - 1);
      map.remove(val);
      return true;
  }
  
  public int getRandom() {
      return list.get(random.nextInt(list.size()));
  }
}

/**
 * 設計一個數據結構可以在O(1)時間內插入、刪除和獲取隨機元素
 * 
 * 思路：即然要O(1)，應該直接聯想到哈希表，其查找、插入、刪除的時間複雜度都是O(1)
 * 插入：如果已經存在的話，return false；如果不存在則插入並返回true
 * 刪除：如果不存在直接返回false；如果存在，把最後一個元素放到要刪除的位置，然後刪除最後一個元素
 * 獲取隨機元素：使用Java中的Random
 **/