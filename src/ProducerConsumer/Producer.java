package ProducerConsumer;

import java.util.Objects;
import java.util.Queue;

public class Producer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;

    Producer(Queue<Object> objects, int maxSize, String name) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (objects.size() < maxSize) {
                objects.add(new Object());
            }
        }
    }
}
