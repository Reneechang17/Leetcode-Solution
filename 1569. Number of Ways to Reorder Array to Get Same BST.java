// Hard
// BST, DP, Math
// Time:O(n^2),Space: O(n^2)
// https://leetcode.cn/problems/number-of-ways-to-reorder-array-to-get-same-bst/

import java.util.*;

class Solution {
  private static final int MOD = 1_000_000_007;
  private long[][] comb;

  public int numOfWays(int[] nums) {
    int n = nums.length;
    comb = new long[n][n];
    for (int i = 0; i < n; i++) {
      comb[i][0] = comb[i][i] = 1;
      for (int j = 1; j < i; j++) {
        comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
      }
    }
    return (int) ((dfs(new ArrayList<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)))) - 1 + MOD)
        % MOD);
  }

  private long dfs(List<Integer> nums) {
    if (nums.size() <= 2)
      return 1;
    int root = nums.get(0);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int num : nums.subList(1, nums.size())) {
      if (num < root)
        left.add(num);
      else
        right.add(num);
    }

    long leftWay = dfs(left) % MOD;
    long rightWay = dfs(right) % MOD;

    return (((comb[nums.size() - 1][left.size()] * leftWay) % MOD) * rightWay) % MOD;
  }
}

/**
 * BST的插入规则为：从nums[0]开始作为根，依次插入nums[1:]，比root小的放左子树，大的放右子树，递归操作
 * 组合数学：
 * C(n-1, leftSize) = (n-1)! / (leftSize! * rightSize!)：计算在n-1个元素中选择leftSize个放入左子树的方式
 * 这里的n-1是nums[1:]的大小
 * 计算方式：ways = C(n-1, leftSize) * leftWays * rightWays
 */
