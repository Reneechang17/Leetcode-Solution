// Easy
// Math
// O(1)
// https://leetcode.com/problems/add-digits/

class Solution {
  public int addDigits(int num) {
    return (num - 1) % 9 + 1;
  }
}

/**
 * 數字根的問題：可以直接用簡化公式⇒ (num - 1) % 9 + 1
 **/

/**
 * ### 解法解释
 * 直接使用 `(num - 1) % 9 + 1`的方法是基于数字根的一个简化公式，这种方法非常高效。在数字根问题中，给定一个非负整数，重复加所有位直到结果只剩下一位数。这个过程与数字 9 的性质密切相关，因为 9 是 10-1，而 10 是我们常用的数位基数（十进制）。
 * 
 * ### 数字根和 `(num - 1) % 9 + 1` 的解释
 * 对于任何正整数，其数字根可以通过 num % 9 得到，但有两个特殊情况需要处理：
 * 1. 当 `num` 是 9 的倍数时，num % 9 返回 0，但我们期望得到 9。
 * 2. 当 `num` 为 0 时，(num - 1) % 9 + 1 结果为 0，这是符合预期的，因为 0 的数字根就是 0。
 * 通过表达式 `(num - 1) % 9 + 1`，我们实际上是在将数字范围从 `[0, 8]` 转换为 `[1, 9]`。这样做保证了：
 * - 如果 `num` 不是 9 的倍数，我们通过 1 将其范围先调整为 0 到 8，然后 +1 回到 1 到 9。
 * - 如果 `num` 是 `9` 的倍数，`num - 1` 仍然保证结果为 8（例如，9-1=8, 18-1=17 等等），模 9 后为 8，然后 +1
 * 使得结果为 9。
 **/