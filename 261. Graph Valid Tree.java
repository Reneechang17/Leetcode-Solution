// Medium
// Union Find
// O(n + e)
// https://leetcode.com/problems/graph-valid-tree/

class Solution {
  public boolean validTree(int n, int[][] edges) {
      // 如果邊的數量不等於n-1，直接返回false
      if (edges.length != n - 1) {
          return false;
      }

      UnionFind uf = new UnionFind(n);

      // 遍歷所有邊，判斷是否有環
      // 如果合併失敗，說明出現環， return false
      for (int[] edge : edges) {
          if (!uf.union(edge[0], edge[1])) {
              return false;
          }
      }
      return true;
  }
}

// 並查集
class UnionFind {
  private int[] parent;
  private int[] rank;

  // 初始化並查集，所有節點的父節點指向自己
  public UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
          parent[i] = i;
      }
  }

  // 查找某個節點的根節點來判斷它屬於哪個集合
  // 例如，如果parent[5]=3,再查parent[3]=1,最後parent[1]=1
  // 那麼可以知道節點5和1是連通的，他們屬於一個集合
  public int find(int p) {
      if (p != parent[p]) {
          parent[p] = find(parent[p]); // 為了方便查找，將樹壓縮成更扁平的結構
      }
      return parent[p];
  }

  // 合併兩個節點所在的連通分量
  public boolean union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);

      // 如果兩個節點的根節點相同，說明在同一個連通分量中，合併會形成環，直接return false
      if (rootP == rootQ) {
          return false;
      }

      // 將較小的樹掛到較大的樹下
      if (rank[rootP] > rank[rootQ]) {
          parent[rootQ] = rootP;
      } else if (rank[rootP] < rank[rootQ]) {
          parent[rootP] = rootQ;
      } else {
          parent[rootQ] = rootP;
          rank[rootP]++;
      }
      return true;
  }
}

/**
 * 判斷一個圖是不是樹：給定一個無向圖，判斷它是不是一顆樹。圖由n個節點和若干條無向邊組成，節點編號從0到n-1
 * 
 * 首先要先了解什麼是樹？ 樹是一個無環連通圖，需要滿足 1. 任意兩個節點之間都有路徑相連 2. 不存在環
 * 圖的節點和邊滿足n個節點和n-1條邊是構成樹的最基本條件。因為樹是一種稀疏圖，對於n個節點的樹，邊數一定是n-1
 * 
 * 思路：因為這題需要判斷是否有環以及檢查連通性，所以用並查集來做
 * 1.對於無環判斷，我們可以判斷添加每一條邊的時候，兩個節點是否已經在同一個連通分量中，如果是的話，加入這條邊就會形成環
 * 2.當遍歷完所有邊後，檢查並查集中是否只有一個連通分量，即所有節點是否都被連通
 **/