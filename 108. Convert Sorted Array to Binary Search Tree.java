// Easy
// Tree, BFS, Array
// O(n)
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    TreeNode root = traversal(nums, 0, nums.length - 1);
    return root;
  }

  private TreeNode traversal(int[] nums, int left, int right) {
    if (left > right)
      return null;
    int mid = left + (right - left >> 1);
    TreeNode root = new TreeNode(nums[mid]);
    root.left = traversal(nums, left, mid - 1);
    root.right = traversal(nums, mid + 1, right);
    return root;
  }
}

/**
 * 將有序數組轉換成BST
 * 
 * 這題要想到sorted array和BST之間的關係
 * 如果BST用中序遍歷的話，就是有序的
 * 
 * 我們可以找到數組的mid，用它當作BST的root，然後將小於他的放在root.left，大於的放在root.right
 **/