package ThreadExecutorExample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        //Executor executor = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executor executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 100; i++) {
            //Print 100 numbers
            PrintNumbers printNumbers = new PrintNumbers(i);

//            if (i == 5 || i == 11 || i == 20) {
//                System.out.println("Debugging......");
//            }

            //executor.execute(printNumbers);
            executorService.execute(printNumbers);
        }

        //We can reuse the ThreadPool.
        executorService.shutdown();
    }
}
