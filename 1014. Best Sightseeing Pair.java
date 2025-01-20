// Medium
// Greedy
// Time:O(n), Space:O(1)
// https://leetcode.cn/problems/best-sightseeing-pair/

class Solution {
  public int maxScoreSightseeingPair(int[] values) {
    int maxScore = Integer.MIN_VALUE;
    int maxLeft = values[0]; // maintain cur max value values[i] + i
    for (int j = 1; j < values.length; j++) {
      // calculate cur score
      maxScore = Math.max(maxScore, maxLeft + values[j] - j);
      // update maxLeft as cur values[j] + j
      maxLeft = Math.max(maxLeft, values[j] + j);
    }
    return maxScore;
  }
}

// 这题首先暴力会超时，所以要把暴力的O(n^2)降到O(n)
// 目标是最大化 values[i] + values[j] + (j - i) -> values[i] + values[j] + j - i
// 根据这个我们可以拆成：values[j] - j -> 与后面的元素j有关
//                  values[i] + i -> 与前面的元素i有关
// 问题变成：在遍历时维护一个当前最大值values[i] + i，然后用它计算后续部分

// 具体优化步骤：
// 1. 遍历数组values[]
// 2. 在每一步计算当前values[j] - j加上之前最大的values[i] + i
// 3. 同时更新values[i] + i的最大值
