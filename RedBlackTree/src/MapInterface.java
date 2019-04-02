package blackredtree;

public interface MapInterface <Key extends Comparable<Key>, Value> {
    public void setValue(Key key, Value value);
    public Value getValue(Key key);
}
