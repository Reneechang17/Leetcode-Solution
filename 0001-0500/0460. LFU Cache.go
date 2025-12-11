package main
// Hard
// https://leetcode.cn/problems/lfu-cache/

type Node struct {
    key, val int
    freq int
    prev, next *Node
}

type DoubleLinkedList struct {
    head, tail *Node
    size int
}

func NewDoubleLinkedList() *DoubleLinkedList {
    dll := &DoubleLinkedList{
        head: &Node{},
        tail: &Node{},
        size: 0,
    }
    dll.head.next = dll.tail
    dll.tail.prev = dll.head
    return dll
}

type LFUCache struct {
    capacity int
    size int
    minFreq int
    keyToNode map[int]*Node
    freqToList map[int]*DoubleLinkedList
}

func Constructor(capacity int) LFUCache {
    return LFUCache{
        capacity: capacity,
        size: 0,
        minFreq: 0,
        keyToNode: make(map[int]*Node),
        freqToList: make(map[int]*DoubleLinkedList),
    }
}

func (this *LFUCache) Get(key int) int {
    if node, exists := this.keyToNode[key]; exists {
        this.incFreq(node)
        return node.val
    }
    return -1
}


func (this *LFUCache) Put(key int, value int)  {
    if this.capacity == 0 {
        return
    }

    if node, exists := this.keyToNode[key]; exists {
        node.val = value
        this.incFreq(node)
    } else {
        if this.size >= this.capacity {
            this.evict() // remove the minFreq and LRU one
        }

        newNode := &Node {
            key: key,
            val: value,
            freq: 1,
        }
        this.keyToNode[key] = newNode

        if this.freqToList[1] == nil {
            this.freqToList[1] = NewDoubleLinkedList()
        }
        this.freqToList[1].addToHead(newNode)
        this.minFreq = 1
        this.size++
    }
}

func (ddl *DoubleLinkedList) addToHead(node *Node) {
    node.prev = ddl.head
    node.next = ddl.head.next
    ddl.head.next.prev = node
    ddl.head.next = node
    ddl.size++
}

func (ddl *DoubleLinkedList) remove(node *Node) {
    node.prev.next = node.next
    node.next.prev = node.prev
    ddl.size--
}

func (ddl *DoubleLinkedList) removeTail() *Node {
    if ddl.size == 0 {
        return nil
    }
    node := ddl.tail.prev
    ddl.remove(node)
    return node
}

func (this *LFUCache) incFreq(node *Node) {
    oldFreq := node.freq
    newFreq := oldFreq + 1

    this.freqToList[oldFreq].remove(node)

    if this.freqToList[oldFreq].size == 0 && oldFreq == this.minFreq {
        this.minFreq = newFreq
        delete(this.freqToList, oldFreq)
    }
    
    node.freq = newFreq

    if this.freqToList[newFreq] == nil {
        this.freqToList[newFreq] = NewDoubleLinkedList()
    }
    this.freqToList[newFreq].addToHead(node)
}

func (this *LFUCache) evict() {
    list := this.freqToList[this.minFreq]
    if list == nil || list.size == 0 {
        return
    }

    node := list.removeTail()
    if node != nil {
        delete(this.keyToNode, node.key)
        this.size--
    }
}
