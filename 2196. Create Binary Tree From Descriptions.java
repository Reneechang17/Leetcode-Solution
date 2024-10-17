// Medium
// Hash Table
// O(n)
// https://leetcode.cn/problems/create-binary-tree-from-descriptions/

import java.util.*;

class Solution {
    // 每個元素是一個三元節點，包含自己和孩子，以及孩子的方向
    // 可以用map來存儲每個節點，根據節點的信息來確定這個節點孩子的位置
    // 然後將孩子存到set，最後遍歷map的key，只要這個key不在set的話，就是根節點（因為我們把孩子放入set）

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>(); // key存元素的值，value存對應的節點
        Set<Integer> set = new HashSet<>();

        for (int[] description : descriptions) {
            TreeNode parent = map.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = map.getOrDefault(description[1], new TreeNode(description[1]));
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            if (!map.containsKey(description[1])) map.put(description[1], child);
            if (!map.containsKey(description[0])) map.put(description[0], parent);
            set.add(description[1]);
        }

        for (int key : map.keySet()) {
            if (!set.contains(key))  {
                return map.get(key);
            }
        }

        return null;
    }
}
