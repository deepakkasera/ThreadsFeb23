package HelloWorldPrinter11Feb;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World!, thread : " + Thread.currentThread().getName());

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        Thread thread = new Thread(helloWorldPrinter);
        thread.start();
    }
}
