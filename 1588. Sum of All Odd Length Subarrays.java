// Easy
// Math
// O(n)
// https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/

class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
      // 所有奇數長度子數組的和
      // 暴力：枚舉出來所有奇數長度的子數組 -> 兩層for循環：一層遍歷起始位置，一層遍歷所有奇數長度子數組
      // 優化：對於每一個元素，計算他在“幾個”奇數長度子數組出現過，直接計算他對結果的貢獻即可

      int n = arr.length;
      int sum = 0;

      for (int i = 0; i < n; i++) {
          // 所有包含arr[i]的子數組
          int totalSubarrays = (i + 1) * (n - i);
          // 加1是因為total子數組可能是奇數也可能是偶數
          // 如果是偶數就是各半，如果是奇數長度會比偶數+1
          int oddSubarrays = (totalSubarrays + 1) / 2;

          sum += oddSubarrays * arr[i];
      }
      return sum;
  }
}

// 怎麼計算所有包含arr[i]的子數組？
// 假設數組arr[a, b, c, d, e]，找出arr[2]=c出現在多少子數組
// 需要考慮arr[2]的左右選擇 -> 分別是位置0-2的選擇 和 2-4的選擇
// (i + 1) 表示從位置0到位置i一共有i+1個可能的子數組起點，包括位置i自己
// (n - i) 表示從位置i到n-1一共有n-i個可能的子數組結束點，包括位置i自己
