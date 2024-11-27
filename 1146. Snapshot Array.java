// Medium
// Hash Table, TreeMap
// Time:O(logn)for set & get,Space:O(nk)
// https://leetcode.cn/problems/snapshot-array/

import java.util.*;

class SnapshotArray {
  private int snapId;
  // map存储每个索引的历史值, key是索引值, val是一个TreeMap<snapId, snap的值
  // TreeMap存储稀疏变化，只存储每个索引的修改记录，每次快照只记录发生了变化的部分
  // 通过floorEntry快速定位快照值，floorEntry用于查找键的API，返回小于或等于给定键的最大键值对（Map.Entry）
  private Map<Integer, TreeMap<Integer, Integer>> history;

  public SnapshotArray(int length) {
      snapId = 0;
      history = new HashMap<>();
      for (int i = 0; i < length; i++) {
          history.putIfAbsent(i, new TreeMap<>());
          history.get(i).put(0, 0);
      }
  }
  
  public void set(int index, int val) {
      history.get(index).put(snapId, val);
  }
  
  public int snap() {
      return snapId++;
  }
  
  public int get(int index, int snap_id) {
      // 找到snap <= snap_id 的最大键对应的值
      return history.get(index).floorEntry(snap_id).getValue();
  }
}
