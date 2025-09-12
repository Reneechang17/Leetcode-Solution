// Medium
// String
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/zigzag-conversion/

class Solution {
    public String convert(String s, int numRows) {
        // basecase
        if (numRows == 1 || s.length() < numRows)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingdown = false;
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);

            if (curRow == 0 || curRow == numRows - 1) {
                goingdown = !goingdown;
            }

            curRow += goingdown ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
