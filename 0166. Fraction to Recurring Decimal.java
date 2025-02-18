// Medium
// Math
// O(d): d is the length of denominator
// https://leetcode.cn/problems/fraction-to-recurring-decimal/

import java.util.*;

class Solution {
  // 感觉是纯恶心人...注意边际情况，例如负数，溢出等
  public String fractionToDecimal(int numerator, int denominator) {
      if (numerator == 0) return "0";
      StringBuilder sb = new StringBuilder();

      // 分子或分母为负数，则为负。分子和分母都是负数，则为正
      boolean isNegative = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);
      if (isNegative) {
          sb.append("-");
      }

      // 将分子分母都转成正数，int -> long, 避免溢出
      long num = Math.abs((long) numerator);
      long den = Math.abs((long) denominator);

      // 先处理整数部分
      sb.append(num / den);
      long remainder = num % den;
      // 如果没有余数，直接return string
      if (remainder == 0) {
          return sb.toString();
      }

      // 处理小数部分，为了确定循环，需要用map记录每个余数出现的位置
      sb.append(".");
      Map<Long, Integer> map = new HashMap<>();

      while (remainder != 0) {
          // 如果某个余数在哈希表中已经出现过，说明从这个位置开始出现循环，将循环部分用括号包围即可
          // 如果余数没有出现过，将当前余数的位置信息存入哈希表中，继续下一步计算
          if (map.containsKey(remainder)) {
              int start = map.get(remainder);
              // 是在指定位置 start 插入一个左括号 (，用于表示循环开始的位置
              sb.insert(start, "(");
              sb.append(")");
              break;
          }
          map.put(remainder, sb.length());

          // 每次将余数乘以10，并将 余数 / 分母 的结果添加到小数部分
          remainder *= 10;
          sb.append(remainder / den);
          remainder %= den;
      }
      return sb.toString();
  }
}
