// Medium
// DFS
// O(n)
// Similar: 364
// https://leetcode.cn/problems/nested-list-weight-sum/

import java.util.List;

class Solution {
  public int depthSum(List<NestedInteger> nestedList) {
      return helper(nestedList, 1);
  }

  private int helper(List<NestedInteger> nestedList, int depth) {
      int sum = 0;
      for (NestedInteger ni : nestedList) {
          if (ni.isInteger()) {
              sum += ni.getInteger() * depth;
          } else {
              sum += helper(ni.getList(), depth + 1);
          }
      }
      return sum;
  }
}

/**
 * 嵌套列表加權和：計算嵌套列表的加權和，其權重為列表的深度
 * 這題可以用遞歸+DFS來做，遞歸處理每一層的元素，如果是整數就直接乘以深度（權重），如果是列表就遞歸處理，深度+1
 **/
