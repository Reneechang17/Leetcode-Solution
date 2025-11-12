// Medium
// DFS
// Time: O(n), Space: O(d)
// https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/

// class Solution {
//     public TreeNode lcaDeepestLeaves(TreeNode root) {
//         return find(root).getKey();
//     }

//     private Pair<TreeNode, Integer> find(TreeNode root) {
//         if (root == null) {
//             return new Pair<>(root, 0);
//         }
//         Pair<TreeNode, Integer> left = find(root.left);
//         Pair<TreeNode, Integer> right = find(root.right);

//         // compare depth
//         if (left.getValue() > right.getValue()) {
//             return new Pair<>(left.getKey(), left.getValue() + 1);
//         }

//         if (left.getValue() < right.getValue()) {
//             return new Pair<>(right.getKey(), right.getValue() + 1);
//         }

//         return new Pair<>(root, left.getValue() + 1);
//     }
// }
