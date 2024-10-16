// Medium
// Hash Table
// O(n)
// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iii/

import java.util.*;

class Solution {
    // 沒有給具體的根節點，但是可以找到每個節點的父節點 -> 可以考慮從下往上找
    // 可以用分別從pq節點回溯到它們的父節點，在p-parent的時候用一個set來紀錄遇到的節點
    // 如果在遍歷q-parent的時候遇到重複的節點，這個節點就是lca
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> vis = new HashSet<>();
        for (Node node = p; node != null; node = node.parent) {
            vis.add(node);
        }

        for (Node node = q; node != null; node = node.parent) {
            if (!vis.add(node)) {
                return node;
            }
        }
        return null; // 但實際上不會執行到這裡，當遍歷到根節點的時候，node.parent = null，此時vis.add(node)返回false
        // 因為null不能被加到set中，導致直接返回null，即根節點
    }
}
