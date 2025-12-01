class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:

    def serialize(self, root):
        # tree -> str
        if not root:
            return "null"
        
        res = []
        que = [root]
        
        while que:
            node = que.pop(0)
            if node:
                res.append(str(node.val))
                que.append(node.left)
                que.append(node.right)
            else:
                res.append("null")
        return ",".join(res)

    def deserialize(self, data):
        # str -> tree
        if data == "null":
            return None
        
        vals = data.split(",")
        root = TreeNode(int(vals[0]))
        que = [root]
        i = 1

        while que and i < len(vals):
            node = que.pop(0)

            if vals[i] != "null":
                node.left = TreeNode(int(vals[i]))
                que.append(node.left)
            i += 1

            if i < len(vals) and vals[i] != "null":
                node.right = TreeNode(int(vals[i]))
                que.append(node.right)
            i += 1
        
        return root
    