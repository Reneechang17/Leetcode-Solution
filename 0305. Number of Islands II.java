// Hard
// Union Find
// Time:O(α(N)),Space:O(m*n)
// https://leetcode.cn/problems/number-of-islands-ii/

import java.util.*;

class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int m, int n) {
            parent = new int[m * n];
            size = new int[m * n];
            count = 0;
            for (int i = 0; i < m * n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (size[rootX] < size[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                }
                count--;
            }
        }

        public void addLand(int x) {
            if (parent[x] == x) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m, n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1], id = r * n + c;
            if (!map.containsKey(id)) {
                uf.addLand(id);
                map.put(id, id);
                for (int[] dir : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && map.containsKey(nr * n + nc)) {
                        uf.union(id, nr * n + nc);
                    }
                }
            }
            res.add(uf.getCount());
        }
        return res;
    }
}
