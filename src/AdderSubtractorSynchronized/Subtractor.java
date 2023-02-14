package AdderSubtractorSynchronized;

public class Subtractor implements Runnable{
    Count count;

    Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            synchronized (count) { //lock only on count object.
                count.value -= i;
            }
        }
    }
}

// Assignment : Read more about synchronized keyword.
