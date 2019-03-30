package HMW1_986636;

public class myPair<T> {

    private T key;
    private int val;

    public myPair(T key, int val) {
        this.key = key;
        this.val = val;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getValue() {
        return val;
    }

    public void setValue(int val) {
        this.val = val;
    }

    @Override
    public String toString() {

        return new StringBuilder().append("(").append(key).append(",").append(val).append(")\n").toString();
    }
}