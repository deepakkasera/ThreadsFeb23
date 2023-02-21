package ProducerConsumerMutex;

import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;
    Lock lock;

    Producer(Queue<Object> objects, int maxSize, String name, Lock lock) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (objects.size() < maxSize) {
//                System.out.println(name + " Producing: " + objects.size());
                objects.add(new Object());
            }
            lock.unlock();
        }
    }
}
