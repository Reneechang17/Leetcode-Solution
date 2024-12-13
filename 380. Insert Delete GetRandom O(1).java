// Medium
// Hash Table, Random
// Time:O(1), Space:O(n)
// https://leetcode.cn/problems/insert-delete-getrandom-o1/

import java.util.*;

class RandomizedSet {
    // Use HashMap for O(1) insert, delete; Use List for O(1) random access
    // Insert: Add val to list and record its index in map
    // Remove: Replace val with the last element in list, update map, and remove the last element
    // Random: Use Random to pick an index from the list
    // Time: O(1) for all operations; Space: O(n) for map and list storage
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(pos, last); // replace val with the last element
        map.put(last, pos); // update the map for last element
        list.remove(list.size() - 1); // remove last element
        map.remove(val); // remove val from map
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
