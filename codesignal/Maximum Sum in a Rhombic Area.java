package codesignal;

class Solution {
  int solution(int[][] matrix, int radius) {
    int maxSum = 0; // 初始化最大和
    int n = matrix.length;

    // 遍歷矩陣中的每一個元素，作為可能的中心點
    // i表示選擇中心點的x座標（行），j表示選擇中心點的y座標（列）
    for (int i = radius - 1; i + radius - 1 < n; i++) {
      for (int j = radius - 1; j + radius - 1 < matrix[0].length; j++) {
        int sum = 0; // 初始化當前菱形的元素和

        // 對每個中心點擴展出菱形區域，計算菱形區域的元素和
        // left表示從中心點向左右擴展
        for (int left = -radius; left <= radius; left++) {
          if (i + left < 0 || i + left >= n) // 檢查是否越界
            continue;
          // right表示從中心點向上下擴展
          for (int right = -radius; right <= radius; right++) {
            // 檢查是否越界
            if (j + right < 0 || j + right >= matrix[0].length)
              continue;

            // 確保選擇的元素在菱形區域內
            if (Math.abs(left) + Math.abs(right) + 1 <= radius) {
              sum += matrix[i + left][j + right];
            }
          }
        }
        // 更新最大和
        if (maxSum < sum) {
          maxSum = sum;
        }
      }
    }
    return maxSum; 
  }
}

/**
 * 問題總結：給定一個矩陣和一個整數radius，找出以每個可能的矩陣元素作為中心，其菱形區域的元素和的最大值
 * 每個菱形的大小是radius，也就是從中心向四個方向（上下左右）的最大步數。只考慮完全位於矩陣內的菱形區域
 * 
 * 思路：比較暴力，就是遍歷每一個可能的中心點元素，然後擴展出菱形區域，計算菱形區域的元素和，更新最大和
 * 沒有用到什麼特殊的DSA，主要就是枚舉找所有可能
 * 
 * 時間複雜度：O((n*m)*r^2)
 **/