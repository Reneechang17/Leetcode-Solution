// Medium
// LinkedList
// Time:O(n), Space:O(h)
// https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/

class Solution {
    private Node last = null;
    private Node head = null;


    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        head.left = last;
        last.right = head;
        return head;
    }

    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);

        if(last != null) {
            last.right = node;
            node.left = last;
        } else {
            head = node;
        }
        
        last = node; // update last as cur node

        inorder(node.right);
    }
}
