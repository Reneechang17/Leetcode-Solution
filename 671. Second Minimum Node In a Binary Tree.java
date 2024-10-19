// Easy
// DFS
// O(n)
// https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/

class Solution {
    // 每個節點都有0/2個節點，並且滿足子節點大於父節點的特性
    // 父節點是兩個子節點中較小的那個
    // 找第二小的值，我們已經可以確定父節點會是最小的
    private int secondMin = -1; 
    private int rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return secondMin;
    }

    private void dfs (TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val > rootVal) {
            if (secondMin == -1 || node.val < secondMin) {
                secondMin = node.val;
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}
