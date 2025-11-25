# Hard
# Design, Hash Table, Doubly Linked List
# Time: O(1), Space:O(capacity)
# https://leetcode.cn/problems/lfu-cache/

# Delete the lowest freq element, if same freq, del the least freq one
# cache: key -> Node
# freq_map: freq -> doubly linked list
# min_freq: easy to find the element should be deleted

from collections import defaultdict

class Node:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.freq = 1
        self.prev = None
        self.next = None

class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {} # key -> node
        # freq -> (head, tail) doubly linkedlist
        # head.next is the latest, tail.prev is the oldest
        self.freq_map = defaultdict(lambda: self._create_list())
        self.min_freq = 0
    
    def _create_list(self):
        head = Node()
        tail = Node()
        head.next = tail
        tail.prev = head
        return (head, tail)
    
    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev

    def _add_to_head(self, head, node):
        node.next = head.next
        node.prev = head
        head.next.prev = node
        head.next = node

    def _update_freq(self, node):
        old_freq = node.freq
        self._remove(node)

        # check if old_freq linkedlist is empty
        head, tail = self.freq_map[old_freq]
        if head.next == tail:
            # this is might the min freq of the linked list
            # update min_freq
            if old_freq == self.min_freq:
                self.min_freq += 1
            # delete the empty linkedlist
            del self.freq_map[old_freq]
        
        # freq +1, add new freq linked list to the head
        node.freq += 1
        head, tail = self.freq_map[node.freq]
        self._add_to_head(head, node)

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        
        node = self.cache[key]
        self._update_freq(node)
        return node.value
        
    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return 
        
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            self._update_freq(node)
        else:
            # new key
            # check capacity
            if len(self.cache) >= self.capacity:
                head, tail = self.freq_map[self.min_freq]
                lfu_node = tail.prev # oldest
                self._remove(lfu_node)
                del self.cache[lfu_node.key]
            
            # create new node and add in
            node = Node(key, value)
            self.cache[key] = node

            # reset min_freq = 1
            self.min_freq = 1

            # add freq = 1's head
            head, tail = self.freq_map[1]
            self._add_to_head(head, node)
            