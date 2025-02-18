// Medium
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/zigzag-conversion/

class Solution {
    // Use array of StringBuilders to simulate rows in zigzag pattern
    // Traverse string, append each char to corresponding row
    //  - change direction when reach top or bottom
    // Finally combine all rows to form the res 
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int curRow = 0;
        boolean goingdown = false;
        for (char c : s.toCharArray()) {
            // Append current character to the corresponding row
            rows[curRow].append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingdown = !goingdown;
            } 
            // if (goingdown) {
            //     curRow += 1;
            // } else {
            //     curRow -= 1;
            // }
            curRow += goingdown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder r : rows) {
            res.append(r);
        }
        return res.toString();
    }
}
