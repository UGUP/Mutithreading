import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientMain4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> unsortedList=  List.of(5,10,11,4,9,3,6);
        ExecutorService executorService= Executors.newCachedThreadPool();
        MergeSorter mergeSorter= new MergeSorter(unsortedList,executorService);
        Future<List<Integer>> sortedListFuture= executorService.submit(mergeSorter);
        List<Integer> sortedList=sortedListFuture.get();
        System.out.println(sortedList);
    }
}
