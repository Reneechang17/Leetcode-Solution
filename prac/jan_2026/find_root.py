"""
Find Root of Tree from Node-Child Pairs

Given a list of (node_id, child_id) pairs representing a tree structure,
where child_id can be None if the node has no child.
Return the root node ID (the node that has no parent).

Example:
Input: [(1, 2), (2, None), (3, 1)]
Tree: 3 -> 1 -> 2
Output: 3

Explanation:
- Node 1 has child 2
- Node 2 has no child  
- Node 3 has child 1
Node 3 is the root because no other node has 3 as a child.
"""

# root is the node that in all nodeIds not have childIds
# Time:O(n), Space:O(n)

def find_root(nodes):
    all_node_ids = set()
    child_ids = set()

    for node_id, child in nodes:
        all_node_ids.add(node_id)
        if child is not None:
            child_ids.add(child)
    
    root_cand = all_node_ids - child_ids

    if not root_cand:
        raise ValueError("No root found!")
    if len(root_cand) > 1:
        raise ValueError("Multiple possible roots found!")
    
    return root_cand.pop()

print("Test 1: Simple tree")
nodes1 = [(1, 2), (2, None), (3, 1)]
print(f"Input: {nodes1}")
print(f"Output: {find_root(nodes1)}")
print()

print("Test 2: Single node")
nodes2 = [(5, None)]
print(f"Input: {nodes2}")
print(f"Output: {find_root(nodes2)}")
print()

print("Test 3: Larger tree")
nodes3 = [
    (10, 5),
    (5, 3),
    (5, 7),
    (3, 1),
    (7, None),
    (1, None),
    (12, 10)
]
print(f"Input: {nodes3}")
print(f"Output: {find_root(nodes3)}")
print()

print("Test 4: Cyclic (should error)")
nodes4 = [(1, 2), (2, 1)]
print(f"Input: {nodes4}")
print(f"Output: {find_root(nodes4)}")
print()

print("Test 5: Forest with multiple roots")
nodes5 = [(1, 2), (3, 4)]
print(f"Input: {nodes5}")
print(f"Output: {find_root(nodes5)}")
