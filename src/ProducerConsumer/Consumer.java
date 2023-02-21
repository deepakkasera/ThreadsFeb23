package ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;
    public Consumer(Queue<Object> objects, int maxSize, String name) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (objects.size() > 0) {
                objects.remove();
            }
        }
    }
}
