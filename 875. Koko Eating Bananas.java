// Medium
// Binary Search
// O(n logm)
// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
  public int minEatingSpeed(int[] piles, int h) {
      int left = 1, right = (int)1e9; // left要從1開始，避免mid為0，mid不能作為除數

      while (left < right) {
          int mid = (left + right) >> 1;
          int sum = 0; 
          for (int x : piles) {
              sum += (x + mid - 1) / mid; // 向上取整
          }
          if (sum <= h) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      return left;
  }
}

/**
 * 愛吃香蕉的可可：有N堆香蕉，第i堆有piles[i]根香蕉，現在可可可以每個小時吃K根香蕉，如果不夠一小時吃完，則會留到下一小時再吃，而守衛會在h小時後回來
 * 求最小的K值，使得可可在h小時內吃完所有香蕉
 * 
 * 思路：首先這題要找最小值，並且piles[i]的數據量很大，也就是可可可以一小時吃很多很多香蕉，用常規O(n)的方法會超時
 * 這裡可以想到二分查找，每次檢查在mid的情況下，可可能不能吃完所有香蕉，如果可以吃完，則往左邊找，否則往右邊找
 * 每次計算小時的sum時，可以用(x + mid - 1) / mid來計算向上取整
 **/