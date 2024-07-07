// Easy
// Math
// O(time)
// https://leetcode.com/problems/pass-the-pillow/

class Solution {
  public int passThePillow(int n, int time) {
    int ans = 1, k = 1;

    while (time-- > 0) {
      ans += k;
      if (ans == 1 || ans == n) {
        k *= -1;
      }
    }
    return ans;
  }
}

/**
 * 遞枕頭，n個人站成一排，編號為1-n
 * 每秒鐘拿著枕頭的人會將枕頭傳給下一個人，一旦隊伍到達隊首or隊尾時，傳遞方向就會改變，隊伍會沿著反方向傳遞枕頭
 * 給定兩個正整數n和time，返回time秒後拿著枕頭的人的編號
 * 
 * 這題需要注意的是，返回的是time秒後的，也就是已經傳遞完了
 * 可以直接用代碼來模擬這個傳遞的情況，用一個k來維護以及表示傳遞的方向，正數1為正的傳，負數表示逆向傳遞
 **/

// 補充：優化到O(1)：
/**
 * 这个做法的时间复杂度是O(time)，还可以优化到O(1)（但我个人觉得不太好想到，这个方法太math并且太tricky了）：
 * 每一轮有n-1次传递，因此我们可以将time 除以n-1得到枕头传递的轮数k，然后再将time对n-1取余得到枕头在当前轮的剩余传递次数mod
 * 接下来判断当前的轮数 k :
 * 如果k为奇数，那么枕头当前的传递方向是从队尾到队首，因此枕头会传递到编号为n-mod的人手中；
 * 如果k为偶数，那么枕头当前的传递方向是从队首到队尾，因此枕头会传递到编号为mod+ 1的人手中。
 **/

 // 代碼
//  class Solution {
//    public int passThePillow(int n, int time) {
//      int k = time / (n - 1);
//      int mod = time % (n - 1);
//      return (k & 1) == 1 ? n - mod : mod + 1;
//   }
//  }