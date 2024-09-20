// Medium
// Binary Search, Two Pointers
// O(log(n - k) + k) ,因為之後還要O(k)來生成結果列表
// https://leetcode.com/problems/find-k-closest-elements/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int left = 0, right = arr.length - k;

      while (left < right) {
        int mid = (left + right) >> 1;
          // 比較x與mid和距離以及mid+k和x的距離，選擇更接近x的一邊
          if (x - arr[mid] > arr[mid + k] - x) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }

      List<Integer> res = new ArrayList<>();
      for (int i = left; i < left + k; i++) {
          res.add(arr[i]);
      }
      return res;
  }
}

/**
 * 找到K個最接近的元素：在一個排序的數組中找最接近x的k個元素，按照升序返回並保持在原數組中的相對順序
 * 接近的定義是絕對差值最小的元素，如果兩個元素距離x的距離相同，返回較小的那個
 * 
 * 思路：首先數組是有序的，其次這種需要定位最xx位置的問題，可以聯想到二分查找快速定位，用來找與x最接近的索引，然後在這個位置用擴展窗口，尋找最接近的k個元素
 **/