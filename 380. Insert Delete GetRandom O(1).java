// Medium
// Hash Table, Random
// O(1)
// https://leetcode.cn/problems/insert-delete-getrandom-o1/

import java.util.*;

class RandomizedSet {
    // O(1) -> 哈希表
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    // 如果存在返回false，不存在則插入返回true
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    // 如果不存在直接返回false，如果存在就把最後一個元素放到要刪除的位置，然後刪掉最後一個元素
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int pos = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(pos, last);
        map.put(last, pos);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    // 直接用Java中的Random
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
