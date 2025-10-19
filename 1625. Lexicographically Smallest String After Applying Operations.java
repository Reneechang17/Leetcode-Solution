// Medium
// BFS
// Time:O(n*10^n), Space:O(n*10^n)
// https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/

// Too hard for me:>

import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> vis = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        que.offer(s);
        vis.add(s);
        String res = s;

        while (!que.isEmpty()) {
            String cur = que.poll();
            if (cur.compareTo(res) < 0) {
                res = cur;
            }

            // Add a to odd pos
            String add = addOdd(cur, a);
            if (vis.add(add)) {
                que.offer(add);
            }

            // rotate b 
            String rotate = cur.substring(cur.length() - b) + cur.substring(0, cur.length() - b);
            if (vis.add(rotate)) {
                que.offer(rotate);
            }
        }
        return res;
    }

    private String addOdd(String s, int a) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ('0' + (chars[i] - '0' + a) % 10);
        }
        return new String(chars);
    }
}
    