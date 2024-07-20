// Medium
// Backtracking
// O(n!)
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> path = new LinkedList<>();
  boolean[] used;

  public List<List<Integer>> permute(int[] nums) {
      if (nums.length == 0) return res;
      used = new boolean[nums.length];
      permuteCheck(nums);
      return res;
  }

  public void permuteCheck(int[] nums) {
      if (path.size() == nums.length) {
          res.add(new ArrayList<>(path));
          return;
      }
      for (int i = 0; i < nums.length; i++) {
          if (used[i]) continue;
          used[i] = true;
          path.add(nums[i]);
          permuteCheck(nums);
          path.removeLast();
          used[i] = false;
      }
  }
}

/**
 * 全排列
 * 
 * 很重要的概念：在排列中[1, 2][2, 1]是兩個不同的排列，並且排列是有序的
 * 所以這題我們不需要start這個index，因為同一個元素可能會再用一次，所以每次遍歷數字都是從index 0的位置開始遍歷
 * 但是還是需要used數組來紀錄已經選擇的元素，因為排列中的一個元素只能使用一次 => if used[i] is true, then we pass it
 * 
 * 這題的時間複雜度是O(n!)，並不是O(2^n)，因為對於全排列來說，每一個位置不只是選擇與不選擇而已的問題
 * 而是：
 * 對於第一個位置，有n種選擇；
 * 對於第二個位置，有n-1種選擇；
 * 對於第三個位置，有n-2種選擇;
 * ....
 * 對於第n個位置，有一種選擇
 * 
 * 每生成一個完整的排列都是一個深度為n的遞歸調用棧，每一個鏈條的某端都是n!的排列結果
 **/