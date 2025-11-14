# src: https://stackoverflow.com/questions/76142856/finding-a-path-between-two-nodes-in-a-k-th-order-fibonacci-tree

# Time:O(n), Space:O(n)
from typing import *

def fib_move_sequence(order, src, dst):
    # size[n] = #nodes of a fib tree of order n
    # recurrence(preorder with root node): size[0]=1, size[1]=1, size[n]=1+size[n-1](r)+size[n-2](l)
    if order < 0:
        order = 0
    size = [1] * max(2, order + 1) # at least 2 slots for basecase 0/1
    for n in range(2, order + 1):
        size[n] = 1 + size[n - 1] + size[n - 2] # +1 is root
    
    # return root->target as 'L'/'R' string
    def path_to(target):
        curr, n = 0, order
        output = []

        if target < 0 or target >= size[order]:
            return ""
        
        while target != curr and n > 1:
            left_size = size[n - 2]
            left_l, left_r = curr + 1, curr + left_size
            if left_l <= target <= left_r:
                output.append('L')
                curr = left_l
                n -= 2 # enter order=n-2' tree(left tree)
            else:
                output.append('R')
                curr = left_r + 1
                n -= 1 # enter order=n-1' tree(right tree)
        
        # if n<=1 and target!=curr, target was invalid for this subtree
        return "".join(output)
    
    a = path_to(src)
    b = path_to(dst)

    # strip longest common prefix -> the common path from root ->LCA
    i = 0
    while i < len(a) and i < len(b) and a[i] == b[i]:
        i += 1

    # len(a)-i: src U to root, b[i:] LCA -> dst(L/R)
    return 'U' * (len(a) - i) + b[i:]
