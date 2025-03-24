// Hard
// DFS -> Apply for the data size, Optimal: Union Find
// Time:O(n² * m), Space:O(n)
// https://leetcode.cn/problems/similar-string-groups/

class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] vis = new boolean[n];
        int group = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                group++;
                dfs(strs, vis, i);
            }
        }
        return group;
    }

    private void dfs(String[] strs, boolean[] vis, int index) {
        vis[index] = true;
        for (int i = 0; i < strs.length; i++) {
            if (!vis[i] && isSimilar(strs[index], strs[i])) {
                dfs(strs, vis, i);
            }
        }
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2)
                    return false;
            }
        }
        return diff == 2 || diff == 0;
    }
}

/**
 * 两个字符串相似表示可以通过交换两个字符得到相同的字符串 => 他们属于同一组 => 问有多少这样的组合
 * 可以把两个字符串看作是图中的节点，如果他们相似，则连成一条边，然后用DFS搜索连通数量
 */
