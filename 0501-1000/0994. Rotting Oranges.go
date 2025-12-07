package main
// Medium
// Time:O(mn), Space:O(mn)
// https://leetcode.cn/problems/rotting-oranges/

func orangesRotting(grid [][]int) int {
    rows, cols := len(grid), len(grid[0])
    que := [][]int{}
    fresh := 0

    for i := 0; i < rows; i++ {
        for j := 0; j < cols; j++ {
            if grid[i][j] == 2 {
                que = append(que, []int{i, j})
            } else if grid[i][j] == 1 {
                fresh++
            }
        }
    }

    if fresh == 0 {
        return 0
    }

    dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
    mins := 0

    for len(que) > 0 {
        levelSize := len(que)

        for i := 0; i < levelSize; i++ {
            cur := que[0]
            que = que[1:]

            for _, dir := range dirs {
                ni, nj := cur[0] + dir[0], cur[1] + dir[1]

                if ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] == 1 {
                    grid[ni][nj] = 2
                    fresh--
                    que = append(que, []int{ni, nj})
                }
            }
        }
        mins++
    }

    if fresh > 0 {
        return -1
    }

    return mins - 1
}
