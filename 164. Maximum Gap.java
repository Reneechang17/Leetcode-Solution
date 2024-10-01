// Medium
// Bucket Sort
// O(n)
// https://leetcode.cn/problems/maximum-gap/

import java.util.Arrays;

class Solution {
  public int maximumGap(int[] nums) {
      if (nums == null || nums.length < 2) {
          return 0;
      }
      // 桶排序題：將[min, max]平均分成若干桶，每個桶的區間寬度為[min, max]/n-1
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      for (int num : nums) {
          min = Math.min(min, num);
          max = Math.max(max, num);
      }

      if (min == max) {
          return 0; // 所有元素都相同
      }

      // 桶的大小和數量
      int n = nums.length;
      int bucketSize = Math.max(1, (max - min) / (n - 1));
      int bucketCount = (max - min) / bucketSize + 1;

      // 初始化每個桶的最大值和最小值
      int[] bucketMin = new int[bucketCount];
      int[] bucketMax = new int[bucketCount];
      Arrays.fill(bucketMin, Integer.MAX_VALUE);
      Arrays.fill(bucketMax, Integer.MIN_VALUE);

      // 按照每個元素的值填充桶
      for (int num : nums) {
          int index = (num - min) / bucketSize;
          bucketMin[index] = Math.min(bucketMin[index], num);
          bucketMax[index] = Math.max(bucketMax[index], num);
      }

      // 最大間距不會出現在桶中，但是會出現在桶與桶之間，因此只需比較相鄰桶的最小值和最大值來得到最大區間
      int maxGap = 0;
      int prevMax = min;
      for (int i = 0; i < bucketCount; i++) {
          if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
              continue;
          }

          maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
          prevMax = bucketMax[i];
      }
      return maxGap;
  }
}
