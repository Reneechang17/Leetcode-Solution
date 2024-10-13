// Medium
// DFS, Recursion
// O(n)
// https://leetcode.cn/problems/find-leaves-of-binary-tree/

import java.util.*;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        // 找到左右子樹的葉子 -> 收集葉子到結果列表並刪除 -> 不斷重複 -> 遞歸
        // 高度 -> def:該節點到葉子節點的距離，葉子節點的高度為0，非葉子節點的高度為其左右子樹最大高度+1
        // 高度h表示節點在第h輪被移除
        dfs(root); // 遞歸找每個節點的高度並將節點加到結果列表
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 先遞歸計算當前節點左右子樹的高度
        int left = dfs(root.left);
        int right = dfs(root.right);

        // 當前節點的高度是左右子樹中較大的+1
        int h = Math.max(left, right);

        // 如果結果列表的大小等於高度，代表還沒創建這一層的列表
        if (res.size() == h) {
            res.add(new ArrayList<>());
        }

        // 將當前節點的值加入對應高度的列表中
        res.get(h).add(root.val);
        return h + 1; // 返回當前節點的高度
    }
}
