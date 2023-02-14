package AdderSubstractor;

public class Adder implements Runnable{
    Count count;

    Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            count.value += i;
        }
    }
}
