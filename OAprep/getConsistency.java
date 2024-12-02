package OAprep;
/**
 * The problem requires calculating the "k-consistency score" for a list of
 * stock prices by removing up to k elements to maximize the number of
 * consecutive identical values in the remaining array.
 * 
 * Problem:
 * You have an array stock_prices representing daily percentage returns.
 * You can perform at most k operations, where each operation allows you to
 * remove any day's stock price.
 * The goal is to maximize the length of the longest subarray with consecutive
 * identical values after removing up to k elements.
 **/

// class Solution {
//   public int getkConsistency(int[] stockPrices, int k) {
//     int n = stockPrices.length;
//     int res = 0;

//     for (int i = 0; i < n; i++) {
//       int target = stockPrices[i];
//       int left = 0, right = 0, removeCnt = 0;

//       // use right to expand the window
//       while (right < n) {
//         if (stockPrices[right] != target) {
//           removeCnt++;
//         }

//         // if remove exceed k, we need to move left to shrink the window
//         while (removeCnt > k) {
//           if (stockPrices[left] != target) {
//             removeCnt--;
//           }
//           left++;
//         }

//         // calculate the window size and update the maxConsistency
//         res = Math.max(res, right - left + 1);
//         right++;
//       }
//     }
//     return res;
//   }
// }