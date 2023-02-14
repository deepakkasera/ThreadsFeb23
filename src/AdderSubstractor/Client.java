package AdderSubstractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count(0);

        Thread t1 = new Thread(new Adder(c));
        Thread t2 = new Thread(new Subtractor(c));

        t1.start();
        t2.start();

        t1.join(); //This method wait to complete the thread, code will not go to the next line till t1 completes.
        t2.join();

        System.out.println(c.value);
    }
}
