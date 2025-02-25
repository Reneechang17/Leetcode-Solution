// Medium
// Math
// Time:O(1), Space:O(1)
// https://leetcode.cn/problems/rectangle-area/

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)- Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1)) * Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
    }
}
/*
    假设左边是 a, 右边是 b
    ┌--------┓
    |        |
    |    ┌---╋-----┓ 
    |    |   |     |
    ┗----╋---┘     |
         |         |
         ┗---------┘

    ┗、┓是已知的坐标
    求两个 ╋ :
    左下角: [x1, y1] = [max(ax1, bx1), max(ay1, by1)]
    右上角: [x2, y2] = [min(ax2, bx2), min(ay2, by2)]
    => 重叠部分面积: (x2 - x1) * (y2 - y1)
    
    若没有重叠部分:
    ┌--------┓
    |        |
    |        |  ┌---------┓ 
    |        |  |         |
    ┗--------┘  |         |
                |         |
                ┗---------┘
    那么 x1 = bx1, x2 = ax2 (用上述方式), 即 x2 - x1 < 0
    => max(0, x2 - x1) * max(0, y2 - y1)
*/
