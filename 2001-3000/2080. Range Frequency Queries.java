// Medium
// HashMap, Binary Search
// Time:O(log m),Space:O(n)
// https://leetcode.cn/problems/range-frequency-queries/

import java.util.*;

class RangeFreqQuery {
    // Use Map to store (value, its appear indexs)
    // Then use Binary Search to find first and last appear index
    
    private Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        // O(n)
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        // O(log m)
        if (!map.containsKey(value)) return 0;
        List<Integer> indexs = map.get(value);
        //  - after left / before right
        int start = lowerBound(indexs, left); // find first pos >= target(left)
        int end = upperBound(indexs, right); // find first pos > target(right)
        return Math.max(0, end - start);
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}