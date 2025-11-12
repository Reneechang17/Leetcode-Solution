// Hard
// Hash Table, Random
// O(1)
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

import java.util.*;

class RandomizedCollection {
  private List<Integer> nums;
  private Map<Integer, Set<Integer>> map;
  private Random random;

  public RandomizedCollection() {
      nums = new ArrayList<>();
      map = new HashMap<>();
      random = new Random();
  }
  
  public boolean insert(int val) {
      boolean notContains = !map.containsKey(val);
      map.putIfAbsent(val, new HashSet<>());
      map.get(val).add(nums.size());
      nums.add(val);
      return notContains;
  }
  
  public boolean remove(int val) {
      if (!map.containsKey(val) || map.get(val).isEmpty()) {
          return false;
      }

      int index = map.get(val).iterator().next();
      map.get(val).remove(index);

      int lastElement = nums.get(nums.size() - 1);
      nums.set(index, lastElement);
      map.get(lastElement).add(index);
      map.get(lastElement).remove(nums.size() - 1);

      nums.remove(nums.size() - 1);

      if (map.get(val).isEmpty()) {
          map.remove(val);
      }
      return true;
  }
  
  public int getRandom() {
      return nums.get(random.nextInt(nums.size()));
  }
}

/**
 * 設計一個數據結構可以在O(1)時間內插入、刪除和獲取隨機元素
 * 和380不一樣，這題允許重複元素，並且每個元素被隨機選取的概率應該和其出現的頻率成正比
 * 
 * 思路：因為要實現O(1)，所以還是要用哈希表，但是這個哈希表的key是元素本身，而value是這個元素出現的所有索引（用HashSet存）
 * 插入：如果元素是第一次出現（不在map中）則返回true，並且將這個元素加入map中，開新的set存儲這個元素出現的索引
 * 刪除：需要先從map找出這個元素的一個索引，將這個索引的元素和數組末尾的元素交換，並且更新map中的索引
 * 刪除數組末尾的元素（已經交換），並且從map中移除這個元素的索引，如果這個元素的索引已經為空，則在map吧這個元素刪除
 * 隨機獲取：直接從數組中隨機獲取一個元素
 **/