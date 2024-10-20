// Medium
// BFS
// O(n)
// https://leetcode.cn/problems/minimum-knight-moves/

import java.util.*;

class Solution {
    // 求從原點走到(x,y)的最少步數 -> 最短距離 -> BFS
    // BFS -> Queue保存當前訪問的座標，並用一個vis來紀錄是否訪問，避免重複
    // 每次訪問都從隊列poll一個座標和(x,y)比較，如果不是的話就擴展繼續找

    private static final int[][] DIRECTIONS = {
        {2,1}, {2,-1}, {-2,1}, {-2,-1},
        {1,2}, {1,-2},{-1,2},{-1,-2}
    };

    public int minKnightMoves(int x, int y) {
        // 因為棋盤是對稱的，可以把目標限制在第一象限，也就是x&y都大於零的情況 -> 絕對值
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> que = new LinkedList<>();
        // 用String是一種簡化，為了方便存儲和檢查座標是否訪問過，簡單的將二維座標轉化爲一個唯一標識符
        // 也可以存成int[], 但是要自己實現equals和hashCode方法
        Set<String> vis = new HashSet<>();

        que.offer(new int[]{0, 0});
        vis.add("0, 0");
        int ans = 0;

        while(!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                int[] cur = que.poll();
                int curX = cur[0], curY = cur[1];

                if (curX == x && curY == y) {
                    return ans;
                }

                for (int[] d : DIRECTIONS) {
                    int nextX = curX + d[0], nextY = curY + d[1];
                    String nextPos = nextX + "," + nextY;

                    if (!vis.contains(nextPos) && nextX >= -1 && nextY >= -1) {
                        que.offer(new int[]{nextX, nextY});
                        vis.add(nextPos);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
