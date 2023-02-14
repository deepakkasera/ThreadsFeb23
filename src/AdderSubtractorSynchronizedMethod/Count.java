package AdderSubtractorSynchronizedMethod;

public class Count {
    private int value = 0;

    Count (int value) {
        this.value = value;
    }

    public synchronized void addValue(int offSet) {
        this.value += offSet;
    }

    public int getValue() {
        return this.value;
    }
}
