package blackredtree;

public class RedOnlyLeftTree<Key extends Comparable<Key>, Value> implements MapInterface<Key, Value> {

    private Node<Key, Value> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false; 
    
    public RedOnlyLeftTree(Node<Key, Value> root) {
        this.root = root;
    }
    
    public RedOnlyLeftTree() {
    }

    @Override
    public void setValue(Key key, Value value) {
        if(key == null || value == null) {
            return;
        }

        Node<Key, Value> inserted = new Node<>(key, value);
        Node<Key, Value> y = null; // rodzic poniższego wskaźnika
        Node<Key, Value> x = root; // wskaźnik, który pomoże nam znaleźć pasującego liścia

        while(x != null) {
            y = x;

            if(key.compareTo(x.getKey()) < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        inserted.setParent(y);

        if(y == null) {
            root = inserted;
        } else if(key.compareTo(y.getKey()) < 0) {
            y.setLeft(inserted);
        } else {
            y.setRight(inserted);
        }

        enhanceInserted(inserted);
    }
    
    public void enhanceInserted(Node<Key, Value> x) {
        while(x != root && x.getColor() == RED) {
            if(x == x.getParent().getRight()) {
                x = x.getParent();

                if(x.getLeft() != null && x.getLeft().getColor() == RED) {
                    x.getLeft().setColor(BLACK);
                    x.getRight().setColor(BLACK);
                    x.setColor(RED);
                } else {
                    leftRotate(x);
                }
            } else {
                x = x.getParent();

                if(x.getColor() == RED) {
                    x = x.getParent();
                    rightRotate(x);
                }
            }
        }

        root.setColor(BLACK);
    }

    @Override
    public Value getValue(Key key) {
        if(key == null) {
            return null;
        }

        Node<Key, Value> x = root;

        while(x != null) {
            int cmp = key.compareTo(x.getKey());

            if(cmp > 0) {
                x = x.getRight();
            } else if(cmp < 0) {
                x = x.getLeft();
            } else {
                return x.getValue();
            }
        }

        return null;
    }

    public void leftRotate(Node<Key, Value> x) {
        Node y = x.getRight();
        x.setRight(y.getLeft());

        if(y.getLeft() != null) {
            y.getLeft().setParent(x);
        }

        y.setParent(x.getParent());

        if(x.getParent() == null) {
            this.root = y;
        } else if(x == x.getParent().getLeft()) {
            x.getParent().setLeft(y);
        } else {
            x.getParent().setRight(y);
        }

        y.setLeft(x);
        x.setParent(y);

        switchColors(x, y);
    }

    public void rightRotate(Node<Key, Value> y) {
        Node<Key, Value> x = y.getLeft();
        y.setLeft(x.getRight());

        if(x.getRight() != null) {
            x.getRight().setParent(y);
        }

        x.setParent(y.getParent());

        if(y.getParent() == null) {
            this.root = x;
        } else if(y == y.getParent().getLeft()) {
            y.getParent().setLeft(x);
        } else {
            y.getParent().setRight(x);
        }

        x.setRight(y);
        y.setParent(x);

        switchColors(x, y);
    }

    private void switchColors(Node a, Node b) {
        boolean tmpColor = a.getColor();
        a.setColor(b.getColor());
        b.setColor(tmpColor);
    }
    
    public Node getNode(Key key) {
        Node<Key, Value> x = root;

        while(x != null) {
            int cmp = key.compareTo(x.getKey());

            if(cmp > 0) {
                x = x.getRight();
            } else if (cmp < 0) {
                x = x.getLeft();
            } else {
                return x;
            }
        }

        return null;
    }
    
    public Node<Key, Value> getRoot() {
        return root;
    }

}