// Hard
// BFS, TreeSet
// Time:O(nlogn),Space:O(n)
// https://leetcode.cn/problems/minimum-reverse-operations/Did

import java.util.*;

class Solution {
    public int[] minReverseOperations(int n, int p, int[] banned, int k) {
        // 禁止访问位置set
        Set<Integer> ban = new HashSet<>();
        for (int b : banned)
            ban.add(b);

        // 初始化两个set，用于存储可访问的节点
        @SuppressWarnings("unchecked")
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();

        // 初始化所有可以访问的位置
        for (int i = 0; i < n; i++) {
            if (i != p && !ban.contains(i)) {
                sets[i % 2].add(i); // 根据索引的奇偶分配sets
            }
        }

        // 初始结果数组为-1，表示无法访问
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Queue<Integer> que = new LinkedList<>();
        que.add(p);
        res[p] = 0;

        while (!que.isEmpty()) {
            int i = que.poll();

            // 计算可以访问的范围
            int mn = Math.max(i - k + 1, k - i - 1);
            int mx = Math.min(i + k - 1, n * 2 - k - i - 1);

            // 获取当前范围内可以访问的节点
            TreeSet<Integer> set = sets[mx % 2];
            Integer it = sets[mx % 2].ceiling(mn);

            // 遍历并更新结果
            while (it != null && it <= mx) {
                res[it] = res[i] + 1; // 更新操作次数
                que.add(it);
                set.remove(it); // 移除已经访问的节点
                it = set.ceiling(mn); // 找到下一个可以访问的节点
            }
        }
        return res;
    }
}

/**
 * 题目整理（太乱了...:>）：反转一段子数组的顺序来完成从p到其他各个位置的操作，并有一些限制条件，例如不能访问某些位置（banned），每次操作时只能反转长度为k的子数组。找最少的操作。
 * 思路：可以用TreeSet存储每个位置的可访问位置，可以高效做查找和删除，尤其是找到大于某个值的最小元素（ceiling）。然后从p位置开始BFS，保证在最短路径上找到每个位置。
 */
