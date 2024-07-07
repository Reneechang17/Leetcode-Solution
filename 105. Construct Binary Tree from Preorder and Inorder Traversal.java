// Medium
// Tree
// O(n)
// Similar: 106
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      if (preorder.length == 0 || inorder.length == 0) return null;
      return helper (preorder, 0, preorder.length, inorder, 0 ,inorder.length);
  }
  private TreeNode helper(int [] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
      if (preStart == preEnd) return null;
      int split = preorder[preStart];
      TreeNode root = new TreeNode(split);


      int mid;
      for (mid = inStart; mid < inEnd; mid++) {
          if (inorder[mid] == split) break;
      }

      int leftInStart = inStart;
      int leftInEnd = mid;
      int rightInStart = mid + 1;
      int rightInEnd = inEnd;

      int leftPreStart = preStart + 1;
      int leftPreEnd = preStart + 1 + (mid - inStart);
      int rightPreStart = leftPreEnd;
      int rightPreEnd = preEnd;

      root.left = helper(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);
      root.right = helper(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);
      return root;
  }
}

/**
 * 思路和106接近，也是通過前序先找到分割點，對前序和中序做分段構建二叉樹（具體操作可以看106）
 * Note: 後序+中序 以及 前序+中序的組合可以確定一個二叉樹，但是只有後序和前序不能，因為沒有中序不能確定其左右部分，也就是無法切割
 **/