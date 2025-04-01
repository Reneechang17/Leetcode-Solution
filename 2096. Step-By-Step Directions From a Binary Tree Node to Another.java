// Medium
// DFS
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another/

import java.util.*;

class Solution {
    // Find paths from start to root, then find paths from end to root->combine
    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<String> startPath = new ArrayList<>(), destPath = new ArrayList<>();
        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);

        // find common prefix
        int i = 0;
        while (i < startPath.size() && i < destPath.size() && startPath.get(i).equals(destPath.get(i))) {
            i++;
        }

        // move up
        StringBuilder sb = new StringBuilder();
        for (int j = startPath.size() - 1; j >= i; j--) {
            sb.append("U");
        }

        // remaining path in destPath
        for (int j = i; j < destPath.size(); j++) {
            sb.append(destPath.get(j)); // "L" or "R"
        }
        return sb.toString();
    }
    private boolean findPath(TreeNode node, int target, List<String> path) {
        if (node == null) return false;
        if (node.val == target) return true;

        path.add("L");
        if (findPath(node.left, target, path)) return true;
        path.remove(path.size() - 1);

        path.add("R");
        if (findPath(node.right, target, path)) return true;
        path.remove(path.size() - 1);

        return false;
    }
}
