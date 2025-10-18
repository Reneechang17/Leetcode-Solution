// Hard
// Sorting, Array
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/employee-free-time/

// First handle merge intervals
// Then iterate the gap to put in res

import java.util.*;

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        for (List<Interval> emp : schedule) {
            list.addAll(emp);
        }
        Collections.sort(list, (a, b) -> a.start - b.start);

        List<Interval> merged = new ArrayList<>();
        Interval prev = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            // handle merge
            Interval cur = list.get(i);
            if (cur.start <= prev.end) {
                prev.end = Math.max(prev.end, cur.end);
            } else {
                merged.add(prev);
                prev = cur;
            }
        }
        merged.add(prev); // add last

        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            res.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }
        return res;
    }
}
