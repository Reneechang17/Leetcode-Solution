import java.util.List;
class Node {
  public int val;
  public Node left;
  public Node right;
  public Node next;
  public List<Node> children;
  public Node parent;
  public Node prev;
  public Node child;
  Node random;

  public Node() {}
  
  public Node(int _val) {
    val = _val;
    this.next = null;
    this.random = null;
  }

  public Node(int _val, Node _left, Node _right, Node _next) {
    val = _val;
    left = _left;
    right = _right;
    next = _next;
  }
}
