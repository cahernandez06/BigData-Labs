package HMW2_PB_986636;

public class myPair<T, U> {

    private T key;
    private U value;

    public myPair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public U getValue() {
        return value;
    }

    public void setValue(U value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("<").append(key).append(",").append(value).append(">\n").toString();
    }
}
