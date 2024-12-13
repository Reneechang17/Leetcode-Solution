// Medium
// Set
// Time:O(n), Space:O(n)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iii/

import java.util.*;
class Solution {
    // Since there is no specific root node, but we can track the parent node 
    // Traverse all ancestors of 'p' and store them in a set
    // Traverse ancestors of 'q', and the first overlap with the set is LCA
    // This works because the first common ancestor will appear during the traversal
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<>();
        for (Node node = p; node != null; node = node.parent) {
            set.add(node);
        }
        for (Node node = q; node != null; node = node.parent) {
            if(!set.add(node)) {
                return node;
            }
        }
        return null;
    }
}
