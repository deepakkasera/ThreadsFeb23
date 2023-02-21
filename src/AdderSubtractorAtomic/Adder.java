package AdderSubtractorAtomic;

import java.nio.file.AtomicMoveNotSupportedException;
import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable{
    AtomicInteger value;

    Adder(AtomicInteger value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            value.addAndGet(i);
            //count.value += i;
        }
    }
}
