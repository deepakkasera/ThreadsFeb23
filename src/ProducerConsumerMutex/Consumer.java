package ProducerConsumerMutex;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;
    Lock lock;
    public Consumer(Queue<Object> objects, int maxSize, String name, Lock lock) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (objects.size() > 0) {
//                System.out.println(name + "is Cosuming " + objects.size());
                objects.remove();
            }
            lock.unlock();
        }
    }
}
