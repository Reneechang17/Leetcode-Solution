// Medium
// Counting
// O(n)
// https://leetcode.com/problems/bulls-and-cows/

class Solution {
  public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];

    for (int i = 0; i < secret.length(); i++) {
      int s = secret.charAt(i) - '0';
      int g = guess.charAt(i) - '0';
      if (s == g) {
        bulls++;
      } else {
        // 如果先前secret的位置計數小於0，表示guess中已經有這個數字
        if (numbers[s] < 0)
          cows++;
        // 如果先前guess的位置計數大於0，表示secret中已經有這個數字
        if (numbers[g] > 0)
          cows++;
        numbers[s]++;
        numbers[g]--;
      }
    }
    return bulls + "A" + cows + "B";
  }
}

/**
 * 1A2B的遊戲，如果字母和位置都相同則是A，字母存在但是位置有誤為B
 * 
 * 可以用計數器的思維做，用一個數組來統計祕密數字中每個數字出現的頻率（數組大小為10，0-9）
 * 如果s和g相同，那麼bulls++；如果先前secret的位置計數小於0，表示guess中已經有這個數字 && 如果先前guess的位置計數大於0，表示secret中已經有這個數字，這兩種情況 cows++
 * 並且更新計數器numbers[s] & numbers[g]
 **/