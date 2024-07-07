// Medium
// Tree
// O(n)
// Similar: 105
// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0)
      return null;
    return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
  }

  private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    if (postStart == postEnd)
      return null;
    int splitIndex = postorder[postEnd - 1];
    TreeNode root = new TreeNode(splitIndex);

    int mid;
    for (mid = inStart; mid < inEnd; mid++) {
      if (inorder[mid] == splitIndex)
        break;
    }

    int leftInStart = inStart;
    int leftInEnd = mid;
    int rightInStart = mid + 1;
    int rightInEnd = inEnd;

    int leftPostStart = postStart;
    int leftPostEnd = postStart + (mid - inStart);
    int rightPostStart = leftPostEnd;
    int rightPostEnd = postEnd - 1;

    root.left = helper(inorder, leftInStart, leftInEnd, postorder, leftPostStart, leftPostEnd);
    root.right = helper(inorder, rightInStart, rightInEnd, postorder, rightPostStart, rightPostEnd);
    return root;
  }
}

/**
 * 如何根據兩個順序構造一個唯一的二叉樹?
 * 以後序數組的最後一個元素為切割點，先切中序數組，再根據中序數組，反過來切後序數組
 * 一層一層切下去，每次後序數組最後一個元素就是節點元素
 * 
 * 代碼：
 * 1. 如果數組大小為0，說明是空節點
 * 2. 如果不為空，那麼取後數組的最後一個元素作為節點元素
 * 3. 找到後序數組最後一個元素在中序數組的位置，作為切割點
 * 4. 切割中序數組，切成中序左數組 & 中序右數組 ⇒ 確定好區間：使用左閉右開
 * 5. 切割後序數組，切成後序左數組 & 後序右數組
 * ❓後序數組用什麼作為切割依據（因為沒有節點）
 * ⇒ 中序數組的大小一定和後序數組的大小是相同的
 * ⇒ 那麼可以按照大小進行切割
 * 6. 遞歸處理左區間和右區間
 * 
 * Note: 後序和中序可以確定一個二叉樹，但是只有後序和前序不能，因為沒有中序不能確定其左右部分，也就是無法切割
 **/