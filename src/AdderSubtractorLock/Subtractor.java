package AdderSubtractorLock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{
    Count count;
    Lock lock;

    Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        for (int i = 1; i <= 10000; i++) {
//            lock.lock();
            count.value -= i;
//            lock.unlock();
        }
        lock.unlock();
    }
}
