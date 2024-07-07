// Medium
// Math
// O(n)
// https://leetcode.com/problems/reverse-integer/

class Solution {
  public int reverse(int x) {
    long res = 0;
    while (x != 0) {
      res = res * 10 + x % 10;
      x /= 10;
      if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
        return 0;
      }
    }
    return (int) res;
  }
}

/**
 * 這題是給出一個32位的整數，需要將其數字順序顛倒。如果顛倒後的整數溢出32位的有效整數的範圍[-2^31, 2^31 - 1]，返回0
 * 假設環境不允許存儲64位整數（有符號或無符號）
 * 
 * 這題的關鍵在於處理邊界條件，確保反轉的過程中不會產生溢出
 * 
 * 思路：透過循環逐個取出整數x的最後一位，並將其加到res中。每次迭代中，先將res乘以10，再加上x的最後一位（通過x%10得到），為了防止整數溢出，使用long來存儲結果
 * 如果在任何階段res超出32位整數的範圍，就返回0
 * 
 * 最後，如果res在有效範圍內，則將其強制轉換位int並返回
 **/