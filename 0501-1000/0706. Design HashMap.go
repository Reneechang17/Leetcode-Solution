package main
// Easy
// HashMap
// Time:O(1),Space:O(n)
// https://leetcode.cn/problems/design-hashmap/

// Can easily use Array, but it wastes memory.
// LinkedList and bucket would be more make sense~

type MyHashMap struct {
    buckets [1009]*Node
}

type Node struct {
    key int
    val int
    next *Node
}

func Constructor() MyHashMap {
    return MyHashMap{
        buckets: [1009]*Node{},
    }
}

func (this *MyHashMap) hash(key int) int {
    return key % 1009
}

func (this *MyHashMap) Put(key int, value int)  {
    index := this.hash(key)

    // create head node if bucket == nil
    if this.buckets[index] == nil {
        this.buckets[index] = &Node{key: key, val: value}
        return
    }

    cur := this.buckets[index]
    for {
        if cur.key == key {
            cur.val = value
            return
        }
        if cur.next == nil {
            cur.next = &Node{key: key, val: value}
            return
        }
        cur = cur.next
    }
}

func (this *MyHashMap) Get(key int) int {
    index := this.hash(key)
    cur := this.buckets[index]
    for cur != nil {
        if cur.key == key {
            return cur.val
        }
        cur = cur.next
    }
    return -1
}

func (this *MyHashMap) Remove(key int)  {
    index := this.hash(key)
    if this.buckets[index] == nil {
        return
    }

    if this.buckets[index].key == key {
        this.buckets[index] = this.buckets[index].next
        return
    }

    prev := this.buckets[index]
    for prev.next != nil {
        if prev.next.key == key {
            prev.next = prev.next.next
            return
        }
        prev = prev.next
    }
}
