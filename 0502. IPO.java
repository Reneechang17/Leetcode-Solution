// Hard
// Array, Sorting, Priority Queue(Heap)
// O(n logn)
// https://leetcode.com/problems/4sum-ii/

import java.util.PriorityQueue;

class Solution {
  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    int n = capital.length;
    PriorityQueue<int[]> q1 = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    for (int i = 0; i < n; i++) {
      q1.add(new int[] { capital[i], profits[i] });
    }
    PriorityQueue<Integer> q2 = new PriorityQueue<>((a, b) -> b - a);
    while (k-- > 0) {
      while (!q1.isEmpty() && q1.peek()[0] <= w) {
        q2.add(q1.poll()[1]);
      }
      if (!q2.isEmpty()) {
        w += q2.poll();
      } else {
        break;
      }
    }
    return w;

  }
}

/**
 * 思路：可以用大根堆來找
 * 
 * 我們需要找有限個項目中的最大化的最終資本，其中profits以及啓動這個項目的最小資本是用數組表示的。
 * 
 * 我們可以開一個優先隊列q1，按照項目的啓動資本（capital數組）從小到大排序（需要初始化一下q1）
 * 如果q1堆頂的元素不超過當前已有的資金（w），並且q1非空，我們把它加到另一個由profit大到小排序的優先隊列中
 * 然後處理q2，當q2非空時，我們從堆頂取出利潤加入當前資金，操作k次（因為我們最多可以做k個項目）
 **/