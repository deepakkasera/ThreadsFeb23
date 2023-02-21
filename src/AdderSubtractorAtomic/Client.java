package AdderSubtractorAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger val = new AtomicInteger(0);

        Thread t1 = new Thread(new Adder(val));
        Thread t2 = new Thread(new Subtractor(val));

        t1.start();
        t2.start();

        t1.join(); //This method wait to complete the thread, code will not go to the next line till t1 completes.
        t2.join();

        System.out.println(val.get());
    }
}
