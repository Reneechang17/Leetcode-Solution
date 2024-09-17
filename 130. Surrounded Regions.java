// Medium
// Graph, DFS
// O(m * n)
// https://leetcode.com/problems/surrounded-regions/

class Solution {
  public void solve(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }

    int row = board.length;
    int col = board[0].length;

    // 從邊界開始，找到所有與邊界相連的O，標記為B（暫時不改變
    for (int i = 0; i < row; i++) {
      dfs(board, i, 0); // 左邊界
      dfs(board, i, col - 1); // 右邊界
    }

    for (int j = 0; j < col; j++) {
      dfs(board, 0, j); // 上邊界
      dfs(board, row - 1, j); // 下邊界
    }

    // 將未標記的O變成X，將已經標記的B變回O
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'B') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void dfs(char[][] board, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
      return;
    }
    board[i][j] = 'B';

    dfs(board, i - 1, j);
    dfs(board, i + 1, j);
    dfs(board, i, j - 1);
    dfs(board, i, j + 1);
  }
}

/**
 * 被包圍的區域：給定一個二維網格，裡面包含X和O，找到所有被X包圍的O，並將其變為X，但不會改變那些與邊界上的'O'直接或間接相連的'O'
 * 
 * 這題也是一題圖與DFS的經典題，可以反向思考：我們從邊界開始檢查，標記所有不能被圍住的O，剩下的就是被'X'包圍的區域
 * 從邊界上所有的'O'出發，DFS搜索所有與邊界相連的'O'，標記為B。再遍歷整個board，將沒有被標記的O轉換成X，將被標記為B的轉換回O
 **/