package AdderSubtractorLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count(0);
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Adder(c, lock));
        Thread t2 = new Thread(new Subtractor(c, lock));

        t1.start();
        t2.start();

        t1.join(); //This method wait to complete the thread, code will not go to the next line till t1 completes.
        t2.join();

        System.out.println(c.value);
    }
}
