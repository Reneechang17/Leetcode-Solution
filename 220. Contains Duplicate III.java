// Hard
// https://leetcode.cn/problems/contains-duplicate-iii/

import java.util.*;

class Solution {
  // Sliding Window + TreeSet
  // Time:O(nlogk), Space:O(k)
  //  - when dataset is large but t and k are small
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      if (k <= 0 || t < 0) return false;

      TreeSet<Long> set = new TreeSet<>();
      for (int i = 0; i < nums.length; i++) {
          long cur = nums[i];
          // check if there is a num within [cur - t, cur + t]
          Long floor = set.floor(cur + t);
          Long ceiling = set.ceiling(cur - t);

          if ((floor != null && floor >= cur) || (ceiling != null && ceiling <= cur)) {
              return true;
          }
          
          // add cur num to set
          set.add(cur);
          // keep the size of sliding window within k
          if (set.size() > k) {
              set.remove((long) nums[i - k]);
          }
      }
      return false;
  }
}

class Solution2 {
  // Use Sliding Window + Bucket sort to optimize
  //  - when dataset is super huge
  // Divide the nums into buckets of size t + 1 to ensure all nums within differ by at most t.
  // Nums in adjacent buckets might also satisfy the condition, so check neighboring buckets.
  // Use a HashMap to simulate the buckets and keep the size of the sliding window within k.
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
      if (k <= 0 || t < 0) return false;

      Map<Long, Long> bucketMap = new HashMap<>(); // map{bucketId, value}
      long size = (long) t + 1; // bucket size

      for (int i = 0; i < nums.length; i++) {
          long bucketId = getBucketId(nums[i], size);

          // check if cur bucket contains valid value
          if (bucketMap.containsKey(bucketId)) {
              return true;
          }

          // check adjacent buckets
          if (bucketMap.containsKey(bucketId - 1) && Math.abs(bucketMap.get(bucketId - 1) - nums[i]) < size) {
              return true;
          }
          if (bucketMap.containsKey(bucketId + 1) && Math.abs(bucketMap.get(bucketId + 1) - nums[i]) < size) {
              return true;
          }

          // add cur value to the bucket
          bucketMap.put(bucketId, (long) nums[i]);

          // remove value out of range k
          if (i >= k) {
              bucketMap.remove(getBucketId(nums[i - k], size));
          }
      }
      return false;
  }

  private long getBucketId(long num, long size) {
      return num < 0 ? (num + 1) / size - 1 : num / size;
  }
}
