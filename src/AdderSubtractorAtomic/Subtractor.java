package AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtractor implements Runnable{
    AtomicInteger value;

    Subtractor(AtomicInteger value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            //count.value -= i;
            value.addAndGet(-i);
        }
    }
}
