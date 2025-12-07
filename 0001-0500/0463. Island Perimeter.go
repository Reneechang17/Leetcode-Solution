package main
// Easy
// Time:O(mn), Space:O(1)
// https://leetcode.cn/problems/island-perimeter/

func islandPerimeter(grid [][]int) int {
    rows, cols := len(grid), len(grid[0])
    perimeter := 0

    dirs := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}

    for i := 0; i < rows; i++ {
        for j := 0; j < cols; j++ {
            if grid[i][j] == 1 {
                for _, dir := range dirs {
                    ni, nj := i + dir[0], j + dir[1]
                    
                    if ni < 0 || ni >= rows || nj < 0 || nj >= cols || grid[ni][nj] == 0 {
                        perimeter++
                    }
                }
            }
        }
    }
    return perimeter
}
