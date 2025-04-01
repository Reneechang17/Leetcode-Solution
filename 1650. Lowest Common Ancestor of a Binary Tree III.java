// Medium
// Set
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iii/

import java.util.*;
class Solution {
    // Since there is no specific root node, but we can track its parent node 
    // Traverse all ancestors of 'p' and store in set, and traverse ancestors of 'q', the first overlap is LCA
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        for (Node node = p; node != null; node = node.parent) {
            set.add(node);
        }
        for (Node node = q; node != null; node = node.parent) {
            if (!set.add(node)) {
                return node;
            }
        }
        return null;
    }
}
