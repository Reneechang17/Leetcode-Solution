package main
// Medium
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/path-sum-iii/

// We don't need to start from root, could start from any node, so use prefixSum to store

func pathSum(root *TreeNode, targetSum int) int {
    prefixSum := make(map[int]int)
    prefixSum[0] = 1
    return dfs(root, 0, targetSum, prefixSum)
}

func dfs(node *TreeNode, curSum int, targetSum int, prefixSum map[int]int) int {
    if node == nil {
        return 0
    }

    curSum += node.Val
    count := prefixSum[curSum - targetSum]
    prefixSum[curSum]++

    count += dfs(node.Left, curSum, targetSum, prefixSum)
    count += dfs(node.Right, curSum, targetSum, prefixSum)

    prefixSum[curSum]--
    return count
}
