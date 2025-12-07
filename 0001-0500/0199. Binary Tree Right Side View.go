package main
// Medium
// Time:O(n), Space:O(w)
// https://leetcode.cn/problems/binary-tree-right-side-view/

func rightSideView(root *TreeNode) []int {
    res := []int{}
    if root == nil {
        return res
    }

    que := []*TreeNode{root}
    for len(que) > 0 {
        levelSize := len(que)

        // go through cur level
        for i := 0; i < levelSize; i++ {
            node := que[0]
            que = que[1:] // pop out the que

            if i == levelSize - 1 {
                res = append(res, node.Val)
            }

            if node.Left != nil {
                que = append(que, node.Left)
            }
            if node.Right != nil {
                que = append(que, node.Right)
            }
        }
    }
    return res
}
