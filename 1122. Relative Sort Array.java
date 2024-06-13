// Easy
// Hash Table, Sorting
// O(m + n)
// https://leetcode.com/problems/relative-sort-array/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    // 先用哈希表紀錄arr2中每個元素在的index
    Map<Integer, Integer> map = new HashMap<>(arr2.length);
    for (int i = 0; i < arr2.length; i++) {
      map.put(arr2[i], i);
    }

    // 對arr1進行排序
    Integer[] arr1ToInteger = new Integer[arr1.length];
    for (int i = 0; i < arr1.length; i++) {
      arr1ToInteger[i] = arr1[i];
    }
    Arrays.sort(arr1ToInteger, (x, y) -> {
      // 如果兩個元素都出現在arr2中，就按照arr2的排序順序排
      if (map.containsKey(x) && map.containsKey(y)) {
        return map.get(x) - map.get(y);
      }
      // 如果一個元素在arr2中，另一個不在，就讓在arr2中的先出現
      else if (map.containsKey(x)) {
        // 比較器中，負數代表想要讓元素先於前面，使得x在y前面
        return -1;
      } else if (map.containsKey(y)) {
        // 而此時是y在arr2中，y要在前面，我們要讓x在y後面
        return 1;
      }
      // 都不在就自然排序
      else {
        return x - y;
      }
    });

    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = arr1ToInteger[i];
    }
    return arr1;
  }
}

/**
 * 思路：哈希表+排序
 * 1. 先遍歷arr2，用哈希表統計每一個value出現的位置（確定順序）
 * 2. 對arr1進行排序
 * Note：需要把arr1先轉換成Integer
 * 3. 引入比較器，需要考慮三種情況：
 *  a. 如果xy都出現在arr2中，那麼按照arr2的順序排序
 *  b. 如果只有x or y在arr2中，在arr2出現的那個排前面
 *  c. 如果xy都不在arr2，那就按照自然排序
 * 4. 最後把數組轉換回int類型返回
 **/