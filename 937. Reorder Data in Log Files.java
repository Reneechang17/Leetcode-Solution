// Medium
// Custom Sort
// https://leetcode.cn/problems/reorder-data-in-log-files/

import java.util.Arrays;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
      int n = logs.length;
      Pair[] arr = new Pair[n];
      for (int i = 0; i < n; i++) {
          arr[i] = new Pair(logs[i], i);
      }
      Arrays.sort(arr, (a, b) -> logCompare(a, b));
      String[] reorder = new String[n];
      for (int i = 0; i < n; i++) {
          reorder[i] = arr[i].log;
      }
      return reorder;
  }
  public int logCompare(Pair p1, Pair p2) {
      String log1 = p1.log, log2 = p2.log;
      int index1 = p1.index, index2 = p1.index;
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
      if (isDigit1 && isDigit2) return index1 - index2;
      if (!isDigit1 && !isDigit2) {
          int sc = split1[1].compareTo(split2[1]);
          if (sc != 0) {
              return sc;
          }
          return split1[0].compareTo(split2[0]);
      }
      return isDigit1 ? 1 : -1;
  }
}

class Pair {
  String log;
  int index;
  public Pair (String log, int index) {
      this.log = log;
      this.index = index;
  }
}
