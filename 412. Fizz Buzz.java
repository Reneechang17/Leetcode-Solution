// Easy
// Math, Simulation
// O(n)
// https://leetcode.com/problems/fizz-buzz/

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> fizzBuzz(int n) {
      List<String> res = new ArrayList<>();

      for (int i = 1; i <= n; i++) {
          if (i % 3 == 0 && i % 5 == 0) {
              res.add("FizzBuzz");
          } else if (i % 3 == 0) {
              res.add("Fizz");
          } else if (i % 5 == 0) {
              res.add("Buzz");
          } else {
              res.add(Integer.toString(i));
          }
      }
      return res;
  }
}

/**
 * FizzBuzz: 給定一個整數n，從1到n打印每個數字，當這個數字可以被3整除時，打印“Fizz”，當這個數字可以被5整除時，打印“Buzz”，當這個數字可以被3和5整除時，打印“FizzBuzz”
 * 這題基本沒什麼難度就是按照要求打印就可以了，如果不能被3 和5整除，則打印數組本身，需要將類型轉換一下（Java）
 **/