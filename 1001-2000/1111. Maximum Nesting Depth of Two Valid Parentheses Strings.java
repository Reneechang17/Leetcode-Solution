// Medium
// Stack
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

class Solution {
  // 如果我们能均衡的分配深度，让AB交替承担高深度括号，就可以使最大嵌套深度最小化
  // 可以用一个变量计算当前嵌套深度：遇到'('深度++ ; 遇到'('深度--
  //   - 把奇数深度的括号分给A(0)，偶数深度分给B(1)
  public int[] maxDepthAfterSplit(String seq) {
      int n = seq.length(), depth = 0;
      int[] res = new int[n];
      for (int i = 0; i < n; i++) {
          char c = seq.charAt(i);
          if (c == '(') {
              depth++;
              res[i] = depth % 2;
          } else {
              res[i] = depth % 2;
              depth--;
          }
      }
      return res;
  }
}

// 给定一个有效括号字符串seq，需要将它分配到两个组A/B
// 使得AB都是有效括号子序列
// 最大嵌套深度尽可能小（即最深的括号嵌套数尽量减少）
// 返回一个数组，其中arr[i] 表示seq[i]属于A(0)/B(1)
