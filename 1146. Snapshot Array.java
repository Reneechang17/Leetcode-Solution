// Medium
// TreeMap
// https://leetcode.cn/problems/snapshot-array/

import java.util.*;

// each index maintain a history version: [(snap_id, value)]
// use binary search to find the closest version in get()

class SnapshotArray {
    private List<TreeMap<Integer, Integer>> history;
    private int snapId;

    // Time:O(n), Space:O(n)
    public SnapshotArray(int length) {
        history = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(0, 0);
            history.add(map);
        }
        snapId = 0;
    }

    // Time:O(logk), Space:O(1)
    public void set(int index, int val) {
        history.get(index).put(snapId, val);
    }

    // Time:O(1), Space:O(1)
    public int snap() {
        return snapId++;
    }

    // Time:O(logk), Space:O(1)
    public int get(int index, int snap_id) {
        // use TreeMap's floorEntry to find <= snap_id the biggest key
        return history.get(index).floorEntry(snap_id).getValue();
    }
}
