package blackredtree;

public class Node<Key extends Comparable<Key>, Value> {
    
    private Key key;
    private Value value;
    private Node left, right, parent;
    private boolean color;

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.color = true;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }

    public boolean getColor() {
        return color;
    }
    
}
