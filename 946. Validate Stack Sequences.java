// Medium
// Stack
// O(n)
// https://leetcode.com/problems/validate-stack-sequences/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public boolean validateStackSequences(int[] pushed, int[] popped) {
      Deque<Integer> stack = new ArrayDeque<>();
      int i = 0;
      for (int x : pushed) {
          stack.push(x);
          while (!stack.isEmpty() && stack.peek() == popped[i]) {
              stack.pop();
              i++;
          }
      }
      return i == popped.length;
  }
}

/**
 * 驗證棧的序列：給定pushed和popped序列，每個序列的值都不重複
 * 判斷popped是否是pushed的壓棧序列
 * 
 * 這題不能想的太複雜，他其實就是要確定壓棧和出棧的元素是不是一致，我們可以直接做模擬棧就可以
 * 可以開一個棧然後遍歷pushed數組，將pushed的元素壓入棧中，然後判斷棧頂元素是否和popped數組下一個要出棧的元素相等
 * 如果相等，就將棧頂元素彈出並將popped數組下一個要出棧的元素的索引++
 * 最後判斷popped數組的索引是否等於popped數組的長度即可
 **/