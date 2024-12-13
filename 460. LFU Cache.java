// Hard
// https://leetcode.cn/problems/lfu-cache/

import java.util.*;

class LFUCache {
  // 一个全局的minFreq变量，表示当前缓存中的最小访问频率
  // 用Map<Integer, Node> 存储缓存中的键值对，Node记录值和频率
  // 用Map<Integer, LinkedHashSet<Integer>>存储每个频率下的键集合：
  //  - 键集合用LinkedHashSet是因为其插入顺序一致，可以满足LRU特性
  //  - 如果需要移除元素时，从minFreq对应的集合中移除最早插入的键
  private int capacity;
  private int minFreq;
  // quickly find the node through key
  private Map<Integer, Node> keyToNode;
  // key:freq, value: all keys under cur freq(ensure order)
  private Map<Integer, LinkedHashSet<Integer>> freqToKey;

  public LFUCache(int capacity) {
      this.capacity = capacity;
      this.minFreq = 0;
      keyToNode = new HashMap<>();
      freqToKey = new HashMap<>();
  }
  
  public int get(int key) {
      if (!keyToNode.containsKey(key)) {
          return -1;
      }
      Node node = keyToNode.get(key);
      updateFreq(node); // update frequency
      return node.value;
  }
  
  public void put(int key, int value) {
      if (capacity == 0) return;
      if (keyToNode.containsKey(key)) {
          // update value and freq
          Node node = keyToNode.get(key);
          node.value = value;
          updateFreq(node);
          return;
      }
      // if capacity filled
      if (keyToNode.size() == capacity) {
          removeLeast();
      }
      // or add new node
      Node newNode = new Node(key, value, 1);
      keyToNode.put(key, newNode);
      freqToKey.putIfAbsent(1, new LinkedHashSet<>());
      freqToKey.get(1).add(key);
      minFreq = 1;
  }

  private void updateFreq(Node node) {
      int freq = node.freq;
      int key = node.key;

      freqToKey.get(freq).remove(key);
      // if cur freq is empty and the min -> update minFreq
      if(freqToKey.get(freq).isEmpty()) {
          freqToKey.remove(freq);
          if (freq == minFreq) {
              minFreq++;
          }
      }
      node.freq++;
      freqToKey.putIfAbsent(node.freq, new LinkedHashSet<>());
      freqToKey.get(node.freq).add(key);
  }

  private void removeLeast() {
      // 从minFreq对应的集合中移除最早插入的键
      LinkedHashSet<Integer> keys = freqToKey.get(minFreq);
      int key = keys.iterator().next();
      keys.remove(key);
      if (keys.isEmpty()) {
          freqToKey.remove(minFreq);
      }
      keyToNode.remove(key);
  }

  private class Node {
      int key, value, freq;
      Node (int key, int value, int freq) {
          this.key = key;
          this.value = value;
          this.freq = freq;
      }
  }
}
