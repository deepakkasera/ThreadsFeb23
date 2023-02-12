package HelloWorldPrinter11Feb;

public class HelloWorldPrinter implements Runnable {
    public static void doSomething() {
        System.out.println("do something, thread : " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        //Write the code that we want to execute from different thread.
        System.out.println("Hello World, thread : " + Thread.currentThread().getName());
        doSomething();
    }
}
