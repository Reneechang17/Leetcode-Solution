package codesignal;

class Solution {
  String solution(String number) {
    // 標記遍歷過程中是否找到連續的數字
    boolean flag = true;
    StringBuilder sb = new StringBuilder();

    // 遍歷字符串
    for (int i = 0; i < number.length(); i++) {

      // 用while循環來檢查後續的字符是否與當前相同
      int k = i + 1;
      while (k < number.length() && number.charAt(i) == number.charAt(k)) {
        k++;
      }

      int len = k - i; // 計算連續數字的長度（個數）
      // 如果長度大於1，代表有連續數字，將flag設為false
      if (len > 1) {
        flag = false;
      }
      // 將連續數字轉換為數值，並且乘以個數，添加到sb中
      sb.append((number.charAt(i) - '0') * (k - 1));
      i = k - 1; // 將遍歷數組的索引更新到連續數字的最後一個，準備檢查下一個新的數字連續的情況
    }

    // 如果沒有連續數字，直接返回sb
    if (flag) {
      return sb.toString();
      // 如果有連續數字，將sb作為參數遞歸調用solution函數
    } else {
      return solution(sb.toString());
    }
  } 
}

/**
 * 問題總結：要求替換字符串中連續相同的數字，將他們替換成新的數字，直到沒有連續相同的數字為止，例如999433應該先成為2746
 * 
 * 思路：遞歸處理字符串每次的替換，因為第一次替換後可能還會有連續數字的情況。首先遍歷字符串，用while循環來檢查後續的字符是否與當前相同
 * 然後計算連續數字的長度，如果長度大於1，則將flag設為false，表示有連續數字，再將連續數字轉換為數值，並且乘以個數，添加到sb中
 * 最後將遍歷數組的索引更新到連續數字的最後一個，準備檢查下一個新的數字連續的情況
 * 如果沒有連續數字，直接返回sb，如果有連續數字，將sb作為參數遞歸調用solution函數，直到沒有連續數字為止
 * 
 * 時間複雜度：最壞情況是O(n^2)，因為每次遞歸都要遍歷一次字符串, n = number.length()
 **/