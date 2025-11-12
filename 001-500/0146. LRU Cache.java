// Medium
// LinkedList, Hash table
// Time:O(1), Space:O(n) n is the capacity
// https://leetcode.cn/problems/lru-cache/

import java.util.*;

class LRUCache {
    private int capacity;
    // map use to find the corresponding value through key -> O(1)
    private Map<Integer, Node> map;
    // record the cache in order to solve the update 
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    // if key exist, return the corresponding value
    // every time we visit the key-value, we need to update it(move to head)
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node); // update the status
        return node.value;
    }

    // if key exist, update the value
    // if not, add new one and check if the LRU exceed the capacity
    // if filled, remove the least recently used key
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
                Node tail = removeTail();
                map.remove(tail.key);
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
        // 1. remove the node
        // 2. add it to head
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        // orig: node.prev - removeNode - node.next
        // goal: node.prev - node.next
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        // goal: head(dummy) - node - head.next
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private Node removeTail() {
        // goal: removeNode(tail.prev) - tail(dummy)
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}
