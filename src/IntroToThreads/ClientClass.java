package IntroToThreads;

public class ClientClass {

    public static void doSomething() {
        System.out.println("do Something, printed by thread: " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Hello World, printed by thread: " + Thread.currentThread().getName());
        doSomething();
    }
}
