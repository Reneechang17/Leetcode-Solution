// Easy
// DFS, Hash Table, Two Pointers
// O(n)
// https://leetcode.cn/problems/two-sum-iv-input-is-a-bst/

import java.util.*;

class Solution {
    // two sum -> hash table, BST -> DFS
    private Set<Integer> vis = new HashSet<>();
    private int k;

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }

        // first to check if set contains the k - root.val
        if (vis.contains(k - root.val)) {
            return true;
        }
        vis.add(root.val);
        return dfs(root.left) || dfs(root.right);
    }
}

// followup:如果不能用額外空間？
// 可以用BST的特性：中序遍歷為有序數組，來找到目標值 -> Two pointers
class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);

        // sorted array
        int left = 0, right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
