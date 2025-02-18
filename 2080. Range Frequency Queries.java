// Medium
// HashMap, Binary Search
// Time:O(n + qlogn),Space:O(n)
// https://leetcode.cn/problems/range-frequency-queries/

import java.util.*;

class RangeFreqQuery {
  // Use Map to store (value, its appear index)
  // Then use Binary Search to find the first appear value 
  //   - after left / before right
  private Map<Integer, List<Integer>> map;

  public RangeFreqQuery(int[] arr) {
      map = new HashMap<>();
      for (int i = 0; i < arr.length; i++) {
          map.putIfAbsent(arr[i], new ArrayList<>());
          map.get(arr[i]).add(i);
      }
  }
  
  public int query(int left, int right, int value) {
      if (!map.containsKey(value)) return 0;
      List<Integer> indexs = map.get(value);
      int start = lowerBound(indexs, left);
      int end = upperBound(indexs, right);
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
