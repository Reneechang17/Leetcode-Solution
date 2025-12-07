package main
// Medium
// Time:O(n), Space:O(w)
// https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/

func zigzagLevelOrder(root *TreeNode) [][]int {
    res := [][]int{}
    if root == nil {
        return res
    }

    que := []*TreeNode{root}
    flag := true // true -> left to right

    for len(que) > 0 {
        levelSize := len(que)
        level := make([]int, levelSize)

        for i := 0; i < levelSize; i++ {
            node := que[0]
            que = que[1:]

            if flag {
                level[i] = node.Val
            } else {
                level[levelSize - 1 - i] = node.Val
            }
            
            if node.Left != nil {
                que = append(que, node.Left)
            }

            if node.Right != nil {
                que = append(que, node.Right)
            }
        }

        res = append(res, level)
        flag = !flag
    }
    return res
} 
