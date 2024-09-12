// Medium
// DFS
// O(n)
// Similar: 339
// https://leetcode.com/problems/nested-list-weight-sum-ii/

// class Solution {
//   public int depthSumInverse(List<NestedInteger> nestedList) {
//       int maxDepth = findMaxDepth(nestedList);
//       return getWeightedSum (nestedList, maxDepth);
//   }

//   private int findMaxDepth(List<NestedInteger> nestedList) {
//       int max = 0;
//       for (NestedInteger ni : nestedList) {
//           if (ni.isInteger()) {
//               max = Math.max(max, 1);
//           } else {
//               max = Math.max(max, 1 + findMaxDepth(ni.getList()));
//           }
//       }
//       return max;
//   }

//   private int getWeightedSum(List<NestedInteger> nestedList, int maxDepth) {
//       int sum = 0;
//       for (NestedInteger ni : nestedList) {
//           sum += getWeightedSum(ni, maxDepth, 1);
//       }
//       return sum;
//   }
  
//   private int getWeightedSum(NestedInteger ni, int maxDepth, int depth) {
//       if (ni.isInteger()) {
//           return ni.getInteger() * (maxDepth - depth + 1);
//       }
//       int sum = 0;
//       for (NestedInteger child : ni.getList()) {
//           sum += getWeightedSum(child, maxDepth, depth + 1);
//       }
//       return sum;
//   }
// }

/**
 * 嵌套列表加權和II：是339的進階版，區別在於要求不同的權重計算方式：嵌套列表的每個整數都要乘以其深度的倒數，而深度的計算方式是最底層為1，向上逐層遞增
 * 
 * 這題可以做兩次遍歷：第一次遍歷先計算最大深度，第二次遍歷使用到的最大深度來計算加權和，加權公式為：(maxDepth - depth + 1) * value
 **/