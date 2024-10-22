// Medium
// String, Trie, DFS
// add word: O(m), search: O(26^m)
// https://leetcode.cn/problems/design-add-and-search-words-data-structure/

class WordDictionary {
    // 因為search有通配符的問題，所以不能簡單用哈希表或是set來存儲查找
    // 需要用字典樹，也是前綴樹（Trie），可以快速存儲和查找字符串
    private class TrieNode {
        // 用於存儲26個字母的子節點
        TrieNode[] children = new TrieNode[26];
        // 用於表示是否有單詞在此結束
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // add a word to the data structure
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }
    
    // 支持通配符，可以用DFS來做，當遇到通配符，嘗試所有可能的分支
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int i) {
        if (i == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(i);
        if (c == '.') {
            // 如果當前是通配符，檢查所有可能性
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, child, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            // 如果是字母，則按照字母索引查找對應的子節點，並繼續遞歸下一步
            int charIndex = c - 'a';
            TrieNode child = node.children[charIndex];
            return child != null && dfs(word, child, i + 1);
        }
    }
}
