// Medium
// Sorting, Set, Greedy
// O(log n)
// https://leetcode.com/problems/minimum-increment-to-make-array-unique/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length, cnt = 0;
    Set<Integer> set = new HashSet<>();
    set.add(nums[0]);
    for (int i = 1; i < n; i++) {
      if (set.contains(nums[i])) {
        if (nums[i] == nums[i - 1]) {
          nums[i]++;
          cnt++;
          set.add(nums[i]);
        } else {
          int old = nums[i];
          nums[i] = nums[i - 1] + 1;
          cnt += nums[i] - old;
          set.add(nums[i]);
        }
      } else {
        set.add(nums[i]);
      }
    }
    return cnt;
  }
}

/**
 * 思路：先將數組sorting
 * 再對數組遍歷，用set對每個遍歷的進行去重，用cnt統計操作次數
 * 如果這個nums[i]出現過的話，先check它是第一次重複出現還是第x次重複出現
 * 如果是第一次重複出現，就把nums[i]++並放到set里
 * 如果是第x次出現，就讓當前比前一個大（先用一個old紀錄當前值再在前一個基礎上加1），再計算更新後的值和old的差距就是要操作的次數（即cnt要加的值），然後加入set
 * 
 * 這題也可以用Greedy的寫法，只要nums[i]比nums[i-1]小，就讓它比nums[i-1]+1，再計算此時的nums[i]和之前的nums[i]的gap
 * Note：簡單來說就是其實不用開set可以直接在數組上操作
 **/