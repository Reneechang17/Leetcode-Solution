// Medium
// Array, Math
// O(n log log n)
// https://leetcode.com/problems/count-primes/

import java.util.Arrays;

class Solution {
  public int countPrimes(int n) {
      if (n <= 2) return 0;
      
      boolean[] isPrime = new boolean[n];
      Arrays.fill(isPrime, true);
      if (n > 2) {
          isPrime[0] = isPrime[1] = false;
      }

      for (int i = 2; i * i < n; i++) {
          if (isPrime[i]) {
              for (int j = i * i; j < n; j += i) {
                  isPrime[j] = false;
              }
          }
      }

      int cnt = 0;
      for (boolean prime : isPrime) {
          if (prime) cnt++;
      }
      return cnt;
  }
}

/**
 * 計算小於非負整數n的質數的數量。質數只能被1和自身整除，並且大於1
 * 
 * 這種問題一般使用Sieve of Eratosthenes
 * 處理edgecase，當n <= 2 直接返回0
 * 初始一個boolean數組，長度為n，假設所有數都是質數，即數組都填入true（除了0和1），除了isPrime[0]和isPrime[1]設為false
 * 
 * 從第一個質數2開始，遍歷到sqrt(n)。對於每個被認為是質數的數i，將它的所有倍數標記為非質數，可以從i*i開始標記，因為小於i*i的倍數在之前已經被更小的質數的倍數標記過了
 * 最後遍歷isPrime數組，計算true的數量
 **/