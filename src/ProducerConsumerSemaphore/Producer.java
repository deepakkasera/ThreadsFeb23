package ProducerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    Queue<Object> objects;
    int maxSize;
    String name;
    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;

    Producer(Queue<Object> objects, int maxSize, String name, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.name = name;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        //Infinite while loop signifies that we can produce infinite number of items.
        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (objects.size() < maxSize) {
                System.out.println(name + "is Cosuming " + objects.size());
                objects.add(new Object());
            }
            consumerSemaphore.release();
        }
    }
}
