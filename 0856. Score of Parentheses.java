// Medium
// Stack, Counting
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/score-of-parentheses/

import java.util.Stack;
class Solution {
  public int scoreOfParentheses(String s) {
      Stack<Integer> stack = new Stack<>();
      stack.push(0);
      for (char c : s.toCharArray()) {
          if (c == '(') {
              stack.push(0);
          } else {
              // 遇到闭括号则计算分数，如果top==0，表示刚匹配"()"，分数1
              // top>0则说明()里面有内容，分数为2*top，加到前一层括号的分数上
              int top = stack.pop();
              int score = (top == 0) ? 1 : 2 * top;
              stack.push(stack.pop() + score);
          }
      }
      return stack.pop();
  }
}

// "()" 的分数是1 -> 基础分数（最简单的）
// 嵌套"(A)"，A表示其他括号，这个括号的分数*2
//   - 例如"(())" 里面的"()"分数得1，再乘以2，得2
// 拼接A+B，例如"()()"，得1+1=2

// 优化空间：用变量来表示嵌套的深度
// Time:O(n), Space:O(1)
class Solution2 {
  public int scoreOfParentheses(String s) {
      int depth = 0, score = 0;
      for (int i = 0; i < s.length(); i++) {
          if (s.charAt(i) == '(') {
              depth++;
          } else {
              depth--;
              if (s.charAt(i - 1) == '(') {
                  score += 1 << depth; // 2^depth
              }
          }
      }
      return score;
  }
}
