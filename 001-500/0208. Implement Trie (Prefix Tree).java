// Medium
// Trie
// Time:O(m), Space:O(m*k)
// https://leetcode.cn/problems/implement-trie-prefix-tree/

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // TrieNode represent the node in tree
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                // if cur char with no node, create one
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            node = node.children[i];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                return false;
            }
            node = node.children[i];
        }
        return true;
    }
}
