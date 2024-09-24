// Medium
// String, Trie, DFS
// O(m * 26^m)
// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class WordDictionary {
  private TrieNode root;

  public WordDictionary() {
      root = new TrieNode();
  }
  
  public void addWord(String word) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (!node.containsKey(c)) {
          node.put(c, new TrieNode());
        }
        node = node.get(c);
      }
      // mark the end of the word
      node.setEnd();
  }
  
  public boolean search(String word) {
    return searchInNode(word, root);
  }
  
  // DFS
  private boolean searchInNode(String word, TrieNode node) {
      for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          if (c == '.') {
              for (TrieNode child : node.getChildren()) {
                  if(child != null && searchInNode(word.substring(i + 1), child)) {
                      return true;
                  }
              }
              return false;
          } else {
              if(!node.containsKey(c)) {
                  return false;
              }
              node = node.get(c);
          }
      }
      return node.isEnd();
  }
}

class TrieNode {
  private TrieNode[] links;
  private boolean isEnd;

  public TrieNode() {
      links = new TrieNode[26];
  }

  public boolean containsKey(char c) {
      return links[c - 'a'] != null;
  }

  public TrieNode get(char c) {
      return links[c - 'a'];
  }

  public void put(char c, TrieNode node) {
      links[c - 'a'] = node;
  }

  public void setEnd() {
      isEnd = true;
  }

  public boolean isEnd() {
      return isEnd;
  }

  public TrieNode[] getChildren() {
      return links;
  }
}

/**
 * 設計一個數據結構可以添加和搜索單詞，其中搜索的單詞中，可以包含通配符"."，通配符可以匹配任何一個字母
 * 
 * 思路：這題需要用字典樹Trie，Trie可以在O(m)內搜索和插入單詞，m是單詞的長度
 * 這題需要自己設計一個字典樹，使用一個links數組來存儲26個字符的子節點，每個節點還包含一個isEnd標記，用來標記是否為單詞結尾
 * 對於addWord方法：將單詞逐一插入字典樹中，如果字典樹中不存在這個字符，則創建一個新的節點。插入結束後，設置一下End
 * search方法：用DFS來搜索，對於每個字符，如果是通配符，則遍歷所有子節點，如果子節點不為空，則繼續遞歸搜索
 **/