package ProducerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;

    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    public Consumer(Queue<Object> objects, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        //Infinite while loop means Consumer can consumer any number of items.
        while (true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (objects.size() > 0) {
                System.out.println(name + "is Cosuming " + objects.size());
                objects.remove();
            }
            producerSemaphore.release();
        }
    }
}
