'''
Design a decoder for multi-way tree encoding
Tree structure:
- Root: special node '*' with 26 children (0-25)
- Non-root nodes: '*' nodes with children, or leaf nodes with letters
- Decoding: Follow indices path from root to leaf

Example:
  Input: "00" -> root→child0→child0→'a'
  Input: "01" -> root→child0→child1→'b'

Implementation:
1. TreeNode: value (letter or '*'), children list
2. Decoder: store root, decode by following index path
'''

from typing import List, Union

# Time:O(n), Space:O(1)
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.children: List["TreeNode"] = []

class Decoder:
    def __init__(self, root: TreeNode):
        self.root = root

    def _parse_indices(self, indices: Union[str, List[int]]) -> List[int]:
        if isinstance(indices, list):
            return indices

        s = indices.strip()
        if s == "":
            return []

        # support "0,25,3" or "0 25 3"
        parts = s.replace(",", " ").split()
        out = []
        for p in parts:
            if not p.isdigit():
                return []  # invalid token
            out.append(int(p))
        return out

    def decode(self, indices: Union[str, List[int]]) -> str:
        path = self._parse_indices(indices)
        node = self.root

        for i in path:
            if i < 0 or i >= len(node.children):
                return ""
            node = node.children[i]

        # must end at a letter leaf
        if node.val != "*" and len(node.children) == 0:
            return node.val
        return ""

if __name__ == "__main__":
    # Build a 26-way tree:
    # root(*) has 26 children [0..25]
    # - root[0] is internal '*' and has children[0]='a', children[1]='b'
    # - root[1] is internal '*' and has children[0]='c', children[1]='d'
    # - root[25] is leaf 'z'

    root = TreeNode("*")
    root.children = [TreeNode("*") for _ in range(26)]

    # branch 0 -> (a,b)
    root.children[0].children = [TreeNode("a"), TreeNode("b")]

    # branch 1 -> (c,d)
    root.children[1].children = [TreeNode("c"), TreeNode("d")]

    # branch 25 -> 'z' (leaf directly under root)
    root.children[25] = TreeNode("z")

    dec = Decoder(root)

    tests = [
        # ----- list[int] input -----
        ([0, 0], "a"),
        ([0, 1], "b"),
        ([1, 0], "c"),
        ([1, 1], "d"),
        ([25], "z"),        # direct leaf under root
        ([], ""),           # empty path ends at root '*'
        ([0], ""),          # ends at internal '*'
        ([2], ""),          # root[2] exists but is '*' with no children => not a letter leaf
        ([0, 2], ""),       # out of range at second level
        ([26], ""),         # out of range at root
        ([25, 0], ""),      # beyond leaf

        # ----- string input (comma/space separated) -----
        ("0,0", "a"),
        ("0 1", "b"),
        ("1,0", "c"),
        ("25", "z"),
        ("", ""),
        ("0", ""),
        ("0,2", ""),
        ("26", ""),
        ("x,1", ""),        # invalid token
        ("1,-1", ""),       # '-' token -> invalid => parse returns []
    ]

    for inp, expected in tests:
        got = dec.decode(inp)
        ok = "✓" if got == expected else "✗"
        print(f"{ok} input={inp!r}  got={got!r}  expected={expected!r}")
