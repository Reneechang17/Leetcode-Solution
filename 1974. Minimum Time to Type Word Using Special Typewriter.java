// Easy
// String， Greedy
// O(n)
// https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

class Solution {
  public int minTimeToType(String word) {
      int ans = 0;
      int prev = 0;
      for (char c : word.toCharArray()) {
          int cur = c - 'a';
          int t = Math.abs(prev - cur);
          t = Math.min(t, 26 - t); // 這裡是為了取最短的距離，因為可以順時針或逆時針移動，也是貪心的做法
          ans += t + 1;
          prev = cur;
      }
      return ans;
  }
}

/**
 * 鍵入單詞的最少時間：有一個特殊打字機，由一個圓盤和一個指針組成，圓盤上有26個小寫字母，指針指向其中一個字母。只有當指針指向某一個字母時，它才能被鍵入，指針初始化指向字母a
 * 每一秒中可以執行1.順時針or逆時針移動一個字符 2. 鍵入當前指向的字母
 * 給定一個word，計算鍵入這個word所需要的最少時間
 * 
 * 思路：這題其實想不太到什麼算法，那可以考慮直接模擬，遍歷word中的每一個字符，計算每一個字符到前一個字符的距離（可能是順時針or逆時針），取最小值，然後加1，最後返回總和
 * 需要一個prev和cur指針來表示前一個指向的字母和當前的，才可以計算他們的距離
 * 這種做法也是一種貪心，我們每次都找最短的時間（距離），最終就是最短的時間
 **/