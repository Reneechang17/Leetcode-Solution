// Medium
// Iterator
// Time:O(1)-> next() O(n) -> hasNext(),Space:O(1)
// https://leetcode.cn/problems/flatten-2d-vector/

import java.util.NoSuchElementException;

class Vector2D {
    private int[][] vec;
    private int row, col;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        this.row = 0;
        this.col = 0;
    }
    
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int res = vec[row][col];
        col++;
        return res;
    }
    
    public boolean hasNext() {
        // if go to the end of cur row, move to next
        while (row < vec.length && col == vec[row].length) {
            row++;
            col = 0;
        }
        return row < vec.length;
    }
}
