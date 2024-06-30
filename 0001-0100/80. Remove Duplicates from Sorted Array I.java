// Medium
// Array, Two Pointers
// O(n)
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 2)
      return nums.length;

    int i = 1;
    for (int j = 2; j < nums.length; j++) {
      // nums[j] != nums[i - 1], means nums[j] not occur more than twice
      if (nums[j] != nums[i - 1]) {
        // paste nums[j] to i's next one
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}

/**
 * 思路：雙指針解決
 * basecase：數組長度為2的時候直接返回
 * 
 * 初始化：i指針從數組的第二個元素開始（也就是i=1）
 * j指針從數組中的第三個元素開始遍歷，check當前j和i-1是否一樣
 **/

/** 補充：
假設： 初始状态nums = [1, 1, 2, 2, 2, 4, 4, 4, 5]
此時 指针 i 初始设为 1（因为前两个数字最多可以重复一次，直接视为有效）

开始遍历： j 从 2 开始，一直到数组末尾。

当 j = 2（nums[j] = 2）时，检查 nums[j] 是否等于 nums[i - 1]（nums[0] = 1），因为它们不相等，我们增加 i（i = 2），并将 nums[j] 复制到 nums[i] 的位置。
 => 数组变为：[1, 1, 2, 2, 2, 4, 4, 4, 5]
当 j = 3（nums[j] = 2）时，nums[j] 等于 nums[i - 1]（nums[1] = 1），仍然不相等，i 再增加（i = 3），复制 nums[j] 到 nums[i]。
 => 数组保持不变：[1, 1, 2, 2, 2, 4, 4, 4, 5]
当 j = 4（nums[j] = 2）时，nums[j] 等于 nums[i - 1]（nums[2] = 2），这次相等，因此这个 2 被视为重复超过两次，跳过。
当 j = 5（nums[j] = 4）时，nums[j] 不等于 nums[i - 1]（nums[3] = 2），i 增加（i = 4），复制 nums[j] 到 nums[i]。
 => 数组变为：[1, 1, 2, 2, 4, 4, 4, 4, 5]
当 j = 6（nums[j] = 4）和 j = 7（nums[j] = 4）时，因为 nums[j] 等于 nums[i - 1]（nums[4] = 4），跳过这些额外的 4。
当 j = 8（nums[j] = 5）时，nums[j] 不等于 nums[i - 1]（nums[4] = 4），i 增加（i = 5），复制 nums[j] 到 nums[i]。
 => 数组变为：[1, 1, 2, 2, 4, 5, 4, 4, 5]

最终数组和结果:
处理后的数组部分 [1, 1, 2, 2, 4, 5]，长度为 i + 1 = 6。
原地修改的数组看起来可能是 [1, 1, 2, 2, 4, 5, 4, 4, 5]，但只有前6个元素是我们关心的结果
**/

