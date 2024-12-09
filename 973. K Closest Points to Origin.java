// Medium
// Sorting, QuickSelect, Heap
// https://leetcode.cn/problems/k-closest-points-to-origin/

/**
 * 最接近原点的k个点
 * sort: 将所有点按与原点的距离排序，取前k个，适合k接近n的情况
 * partition: 将所有点按与原点的距离分区，找到第k个点，适合k远小于n的情况
 * heap: 维护一个大小为k的最大堆，当堆的大小大于k时，就将距离最大的去除，最后堆中剩下的元素就是最小的k个元素
 * (适用于k比较小的情况，尤其数据量越大时越有效)
 **/

import java.util.*;
class Solution {
  // use sort to sort the points by the distance to the origin, then return the first k points
  // since the square root is monotonically increasing, we can compare x^2+y^2 instead of the actual distance
  // Time:O(nlogn), Space:O(logn)
  public int[][] kClosest(int[][] points, int k) {
    Arrays.sort(points, (a, b) -> {
      return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
    });

    return Arrays.copyOfRange(points, 0, k);
  }
}

class Solution2 {
  // QuickSelect: divide the array such that points with dis less than or equal to the pivot are on the left
  // and those greater are on the right
  // if k=i−left+1 -> means pivot is the k-th closest point
  // if k=i−left+1 -> the pivot is the k-th closest point, and we terminate
  // if k<i−left+1 -> in the left partition, so recursively process the left side
  // Otherwise recursively process the right side
  // After partitioning, the first k points in the array will be the closest points
  // Time: O(n), Space: O(logn)
  Random random = new Random();

  public int[][] kClosest(int[][] points, int k) {
    int n = points.length;
    random_select(points, 0, n - 1, k);
    return Arrays.copyOfRange(points, 0, k);
  }

  private void random_select(int[][] points, int left, int right, int k) {
    // randomly select a pivot index
    int pivotIndex = left + random.nextInt(right - left + 1);
    // calculate the distance of the pivot point
    int pivot = points[pivotIndex][0] * points[pivotIndex][0] + points[pivotIndex][1] * points[pivotIndex][1];
    // swap the pivot point to the rightmost position
    swap(points, right, pivotIndex);

    // partition the arr, points with dis less than or equal to the pivot are on the left
    int i = left - 1;
    for (int j = left; j < right; j++) {
      int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
      if (dist <= pivot) {
        i++;
        swap(points, i, j);
      }
    }
    i++;

    // put the pivot point to the correct position
    swap(points, i, right);

    // check which partition contains the k-th closest point
    if (k < i - left + 1) {
      random_select(points, left, i - 1, k);
    } else if (k > i - left + 1) {
      random_select(points, i + 1, right, k - (i - left + 1));
    }
  }

  private void swap(int[][] points, int i1, int i2) {
    int[] temp = points[i1];
    points[i1] = points[i2];
    points[i2] = temp;
  }
}

class Solution3 {
  // maxHeap
  public int[][] kClosest(int[][] points, int k) {
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
          public int compare(int[] arr1, int[] arr2) {
              return arr2[0] - arr1[0];
          }
      });
      for (int i = 0; i < k; i++) {
          pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
      }
      int n = points.length;
      for (int i = k; i < n; i++) {
          int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
          if (dist < pq.peek()[0]) {
              pq.poll();
              pq.offer(new int[] {dist, i});
          }
      }
      int[][] res = new int[k][2];
      for (int i = 0; i < k; i++) {
          res[i] = points[pq.poll()[1]];
      }
      return res;
  }
}
