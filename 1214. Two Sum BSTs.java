// Medium
// Set, Two pointers, BST
// https://leetcode.cn/problems/two-sum-bsts/

// I quickly come up with two ways, one is using hashset? and it looks pretty similar to 
// two sum but in tree mode, another is using BST' character that we get the order list? when we 
// do inorder traversal.

import java.util.*;

class Solution {
    // Set(two sum way)
    // Time:O(m+n), Space:(m)
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet<>();
        inorder(root1, set);

        return find(root2, set, target);
    }

    private void inorder(TreeNode root, Set<Integer> set) {
        if (root == null)
            return;
        inorder(root.left, set);
        set.add(root.val);
        inorder(root.right, set);
    }

    private boolean find(TreeNode root, Set<Integer> set, int target) {
        if (root == null)
            return false;
        if (set.contains(target - root.val))
            return true;
        return find(root.left, set, target) || find(root.right, set, target);
    }
}

class Solution2 {
    // Two Pointers
    // Time:O(m+n), Space:O(m+n)
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);

        int left = 0, right = l2.size() - 1;
        while (left < l1.size() && right >= 0) {
            int sum = l1.get(left) + l2.get(right);
            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
