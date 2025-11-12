// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/

class Solution {
    public boolean verifyTreeOrder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }
    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right) return true;

        int rootVal = postorder[right];
        int mid = left;

        // find the start point of left subtree: first node > rootVal
        while (postorder[mid] < rootVal) mid++;

        // check if all right subtree val > rootVal
        for (int i = mid; i < right; i++) {
            if (postorder[i] < rootVal) return false;
        }

        return helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }
}
