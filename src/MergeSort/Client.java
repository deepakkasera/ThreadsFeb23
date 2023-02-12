package MergeSort;

import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(7,5,4,1,2,6,3,8);
        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSorter mergeSorter = new MergeSorter(arrayToSort, executorService);
        Future<List<Integer>> sortedArrayFutures = executorService.submit(mergeSorter);

        List<Integer> sortedArray = sortedArrayFutures.get();

        System.out.println(sortedArray);
    }
}
