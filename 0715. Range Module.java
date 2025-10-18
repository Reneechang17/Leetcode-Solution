// Hard
// TreeMap
// https://leetcode.cn/problems/range-module/

import java.util.*;

class RangeModule {
    TreeMap<Integer, Integer> intervals; // start -> end

    public RangeModule() {
        intervals = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        // check left and right
        if (start != null && intervals.get(start) >= left) {
            left = start;
        }

        if (end != null && intervals.get(end) > right) {
            right = intervals.get(end);
        }

        // delete all range cover middle
        intervals.subMap(left, right).clear();
        intervals.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start != null && intervals.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        Integer end = intervals.floorKey(right);

        if (end != null && intervals.get(end) > right) {
            intervals.put(right, intervals.get(end));
        }

        if (start != null && intervals.get(start) > left) {
            int oldEnd = intervals.get(start);
            intervals.put(start, left);
            if (oldEnd > right) {
                intervals.put(right, oldEnd);
            }
        }

        intervals.subMap(left, right).clear();
    }
}
