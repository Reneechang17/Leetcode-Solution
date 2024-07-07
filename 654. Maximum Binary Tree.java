// Medium
// Tree
// O(n)
// https://leetcode.com/problems/maximum-binary-tree/

class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    // 主方法：構建最大二叉樹
    return buildTree(nums, 0, nums.length);
  }

  private TreeNode buildTree(int[] nums, int leftIndex, int rightIndex) {
    // 當前子數組範圍為空，返回null
    if (rightIndex - leftIndex < 1)
      return null;
    // 如果當前子數組的範圍只有一個元素，創建一個節點直接返回
    if (rightIndex - leftIndex == 1)
      return new TreeNode(nums[leftIndex]);

    // 尋找當前子數組範圍內的最大值和其索引
    int maxIndex = leftIndex;
    int maxVal = nums[maxIndex];
    for (int i = leftIndex + 1; i < rightIndex; i++) {
      if (nums[i] > maxVal) {
        maxVal = nums[i];
        maxIndex = i;
      }
    }

    // 以最大值創建根節點
    TreeNode root = new TreeNode(maxVal);

    // 構建左右子樹，範圍是當前子數組的左半/右半部分
    root.left = buildTree(nums, leftIndex, maxIndex);
    root.right = buildTree(nums, maxIndex + 1, rightIndex);
    return root;
  }
}

/**
 * 給定沒有重複元素的整數數組，以此數組構建最大二叉樹的定義為：
 * 二叉樹的根是數組的最大元素；左子樹是通過數組最大值的左邊部分構成的最大二叉樹；同右子樹
 * 
 * 構建樹一般採用前序遍歷，先構建中間節點，再遞歸構建左子樹和右子樹（小的放左邊，大的放右邊）
 **/