// Easy
// DFS
// O(n)
// https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/

class Solution {
    // 每個節點都會有0/2個子節點，並且滿足父節點小於他的兩個子節點的特性
    private int secondMin = -1;
    private int rootVal;
    
    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return secondMin;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // 確定當前節點的值大於根節點的值
        if (node.val > rootVal) {
            // 如果secondMin為-1或者當前節點的值小於secondMin，則更新secondMin
            if (secondMin == -1 || node.val < secondMin) {
                secondMin = node.val;
            }
        }

        dfs(node.left);
        dfs(node.right);
    }
}
