package MergeSort;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Implement Merge Sort in a multi threaded environment
public class MergeSorter implements Callable<List<Integer>> {
    List<Integer> arrayToSort;
    ExecutorService executorService;
    MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }

        int mid = arrayToSort.size()/2;

        List<Integer> leftArray = new ArrayList<>();
        for (int i = 0; i < mid; i++) {
            leftArray.add(arrayToSort.get(i));
        }

        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++) {
            rightArray.add(arrayToSort.get(i));
        }

        //Sorting of 2 half's is an independent task and can be done in parallel.

        MergeSorter leftMergeSorter = new MergeSorter(leftArray, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightArray, executorService);

        Future<List<Integer>> leftSortedFutures = executorService.submit(leftMergeSorter);
        Future<List<Integer>> rightSortedFutures = executorService.submit(rightMergeSorter);

        //List<Integer> leftSorted = leftMergeSorter.call();
        //List<Integer> rightSorted = rightMergeSorter.call();

        List<Integer> leftSorted = leftSortedFutures.get();
        List<Integer> rightSorted = rightSortedFutures.get();
        //Merge the 2 Sorted parts of the array using 2 pointers.
        int i = 0, j = 0;
        List<Integer> sortedArray = new ArrayList<>();

        while (i < leftSorted.size() && j < rightSorted.size()) {
            if (leftSorted.get(i) < rightSorted.get(j)) {
                sortedArray.add(leftSorted.get(i));
                i++;
            } else {
                sortedArray.add(rightSorted.get(j));
                j++;
            }
        }

        while (i < leftSorted.size()){
            sortedArray.add(leftSorted.get(i));
            i++;
        }
        while (j < rightSorted.size()){
            sortedArray.add(rightSorted.get(j));
            j++;
        }

        return sortedArray;
    }
}
