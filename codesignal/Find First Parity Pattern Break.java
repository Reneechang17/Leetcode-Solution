package codesignal;

class Solution {
  int solution(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] % 2 == numbers[i + 1] % 2) {
        return i + 1;
      }
    }
    return -1;
  }
}

/**
 * 問題總結：檢查數組中是否存在連續的奇數或是偶數，如果存在，返回第一個連續數字的索引，如果不存在返回-1
 * 
 * 思路：遍歷一次數組，檢查相鄰的兩個數字是否同為奇數或是同為偶數（用%2判斷），如果是，返回當前元素的下一個元素的索引
 * 時間複雜度：O(n)
 **/