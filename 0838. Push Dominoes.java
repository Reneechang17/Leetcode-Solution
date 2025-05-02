// Medium
// String
// Time:O(n),Space:O(n)
// https://leetcode.cn/problems/push-dominoes/

class Solution {
    public String pushDominoes(String dominoes) {
        String s = 'L' + dominoes + 'R';
        StringBuilder sb = new StringBuilder();

        // i是左边界，j是右边界
        for (int i = 0, j = 1; j < s.length(); j++) {
            if (s.charAt(j) == '.') continue; // 找右边的非'.'字符

            // 处理i之后的那个字符
            if (i > 0) sb.append(s.charAt(i));

            // 计算中间有多少个'.'
            int mid = j - i - 1;

            char left = s.charAt(i), right = s.charAt(j);

            // 1. 两边相同方向
            if (left == right) {
                for (int k = 0; k < mid; k++) {
                    sb.append(left);
                }
            } else if (left == 'L' && right == 'R') {
                // 2. L..R中间稳定 => 保持原状
                for (int k = 0; k < mid; k++) {
                    sb.append('.');
                }
            } else {
                // 3. R..L中间对半分
                // 左半部分向右
                for (int k = 0; k < mid / 2; k++) {
                    sb.append('R');
                }
                // 如果中间有奇数个位置，中间保持原状
                if (mid % 2 == 1) {
                    sb.append('.');
                }
                // 右半部分向左
                for (int k = 0; k < mid / 2; k++) {
                    sb.append('L');
                }
            }
            i = j; // update左边界
        }
        return sb.toString();
    }
}
