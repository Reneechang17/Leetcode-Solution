package main
// Medium
// Time:O(1), Space:O(capacity)
// https://leetcode.cn/problems/lru-cache/

type Node struct {
    key, val int
    prev, next *Node
}

type LRUCache struct {
    capacity int
    cache map[int]*Node // key -> node
    head *Node
    tail *Node 
}


func Constructor(capacity int) LRUCache {
    lru := LRUCache {
        capacity: capacity,
        cache: make(map[int]*Node),
        head: &Node{}, 
        tail: &Node{},
    }
    lru.head.next = lru.tail
    lru.tail.prev = lru.head
    return lru
}


func (this *LRUCache) Get(key int) int {
    if node, exists := this.cache[key]; exists {
        this.moveToHead(node)
        return node.val
    }
    return -1
}


func (this *LRUCache) Put(key int, value int)  {
    if node, exists := this.cache[key]; exists {
        node.val = value
        this.moveToHead(node)
    } else {
        newNode := &Node{key: key, val: value}
        this.cache[key] = newNode
        this.addToHead(newNode)

        if len(this.cache) > this.capacity {
            removed := this.removeTail()
            delete(this.cache, removed.key)
        }
    }
}

func (this *LRUCache) moveToHead(node *Node) {
    this.removeNode(node)
    this.addToHead(node)
}

func (this *LRUCache) removeNode(node *Node) {
    node.prev.next = node.next
    node.next.prev = node.prev
}

func (this *LRUCache) addToHead(node *Node) {
    node.prev = this.head
    node.next = this.head.next
    this.head.next.prev = node
    this.head.next = node
}

func (this *LRUCache) removeTail() *Node {
    node := this.tail.prev
    this.removeNode(node)
    return node
}
