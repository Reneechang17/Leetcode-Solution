// Medium
// Sorting, Partition, Heap(PriorityQueue)
// O(n) -> Partition, O(nlogn) -> Sorting, O(nlogk) -> Heap
// Similar: 215
// https://leetcode.cn/problems/k-closest-points-to-origin/

import java.util.*;
import java.util.stream.IntStream;

class Solution {
  // 找二維座標平面上距離原點最近的k個點
  // 最簡單的方法是用排序計算每個點到原點的距離平方，將平方從小到大排序，返回前k個點
  // 但因為平方根的關係在比較時是單調遞增的，所以可以比較x^2+y^2而不是實際的距離
  public int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, (a, b) -> {
      return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
    });

    return Arrays.copyOfRange(points, 0, k);
  }
}

// followup，因為題目強調返回的點可以是任意順序，所以可以用分區結合快排做
// 將所有點按照與原點的距離分區，然後找到第k個點，這個點左邊的點就是答案
// 這個在k的值比較小的時候會比較高效，但是代碼實現比較複雜

class Solution2 {
  public int[][] kClosest(int[][] points, int k) {
      int n = points.length;
      // k = n - k;
      int[][] pts = IntStream.range(0, n).mapToObj(idx -> new int[]{idx, points[idx][0] * points[idx][0] + points[idx][1] * points[idx][1]}).toArray(int[][]::new);
      partition(pts, k, 0, n - 1);
      return Arrays.stream(pts).map(p -> points[p[0]]).limit(k).toArray(int[][]::new);
  }

  void partition(int[][] pts, int k, int start, int end) {
      if (start >= end) return;
      
      int l = start, r = end;
      int pivot = pts[l + r >> 1][1];
      while (l <= r) {
          while (pts[l][1] < pivot) l++;
          while (pts[r][1] > pivot) r--;
          if (l <= r) {
              int[] temp = pts[l];
              pts[l] = pts[r];
              pts[r] = temp;
              l++;
              r--;
          }
      }
      if (k <= r) partition(pts, k, start, r);
      else if (k >= l) partition(pts, k, l, end);
  }
}

/**
 * 最接近原點的k個點
 * 
 * 思路；這題解法很多，可以用排序，分區，堆等方法
 * 排序：將所有點按照與原點的距離排序，然後取前k個，這是最容易想點的方法
 * 分區：這裡用分區的方法，將所有點按照與原點的距離分區，然後找到第k個點，這個點左邊的點就是答案
 * Note：但是要注意遞歸的終止，當start >= end時，不需要再分區，否則會無限遞歸
 * 優先隊列：維護一個大小為k的最大堆，當堆的大小大於k時，就將距離最大的去除，這樣堆中剩下的元素就是最小的k個元素
 * 
 * 當k接近n的時候，用排序會比較直接有效，但是在k比較小的情況排序整個數組會有點多餘
 * 分區的思想就是Quick Select，在k比較小的時候會很高效，但是代碼實現比較複雜
 * 最大堆也適用於k比較小的情況，尤其數據量越大越有效，實現時會比排序高效但是需要額外的空間
 **/
