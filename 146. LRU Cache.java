// Medium
// LinkedList, Hash table
// O(1)
// https://leetcode.cn/problems/lru-cache/

import java.util.HashMap;

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    // 如果存在key，就返回相應的val
    // 每次訪問都需要將訪問的key-value標記成最新使用
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    // 如果存在key，更新值
    // 如果不存在，插入新的並且檢查緩存是否滿了，滿了就刪除最近使用最少的key-value
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            
            if (map.size() > capacity) {
                Node tailNode = removeTail();
                map.remove(tailNode.key);
            }
        }
    }

    // create the Node class
    private class Node {
        int key, value;
        Node prev, next;
        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        // node.prev - node - node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        // head(dummy) - node - head.next
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        // RemoveNode - tail(dummy)
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}
