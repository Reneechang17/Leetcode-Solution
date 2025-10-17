// Medium
// String
// Time:O(n*m*k), Space: O(n)
// https://leetcode.cn/problems/add-bold-tag-in-string/

class Solution {
    public String addBoldTag(String s, String[] words) {
        int n = s.length();
        boolean[] mark = new boolean[n];

        for (String w : words) {
            int start = 0;
            while ((start = s.indexOf(w, start)) != -1) {
                for (int i = start; i < start + w.length(); i++) {
                    mark[i] = true;
                }
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (mark[i] && (i == 0 || !mark[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (mark[i] && (i == n - 1 || !mark[i + 1])) {
                sb.append("</b>");
            }
        }

        return sb.toString();
    }
}
