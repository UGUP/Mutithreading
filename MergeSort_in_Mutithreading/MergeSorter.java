
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSorter implements Callable<List<Integer>> {

    private List<Integer> unsortedList;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> unsortedList, ExecutorService executorService){
        this.executorService=executorService;
        this.unsortedList=unsortedList;
    }

    @Override
    public List<Integer> call() throws ExecutionException, InterruptedException {

        int sizeOfList= unsortedList.size();

        if(sizeOfList<=1){
            return unsortedList;
        }


        ArrayList<Integer> leftUnsortedList= new ArrayList<>();
        ArrayList<Integer> rightUnsortedList = new ArrayList<>();



        for(int i=0;i<sizeOfList/2;i++){
            leftUnsortedList.add(unsortedList.get(i));
        }

        for(int j=sizeOfList/2;j<sizeOfList;j++){
            rightUnsortedList.add(unsortedList.get(j));
        }


        MergeSorter leftMergeSorter= new MergeSorter(leftUnsortedList,executorService);
        MergeSorter rightMergeSorter= new MergeSorter(rightUnsortedList,executorService);

        Future<List<Integer>> leftSortedListFuture= executorService.submit(leftMergeSorter);
        Future<List<Integer>>  rightSortedlistFuture= executorService.submit(rightMergeSorter);


        List<Integer> leftSorted=  leftSortedListFuture.get();
        List<Integer> rightSorted= rightSortedlistFuture.get();

        // Get is a blocking call so you can use the CompletableFuture check the complateable future and comlete executor service

//        List<Integer> leftSorted=  leftSortedListFuture.;
//        List<Integer> rightSorted= rightSortedlistFuture.get();


        int i=0, j=0;

        ArrayList<Integer> sortedList= new ArrayList<>();

        while(i<leftSorted.size() && j<rightSorted.size()){
            if(leftSorted.get(i)<rightSorted.get(j)){
                sortedList.add(leftSorted.get(i));
                i++;
            }else{
                sortedList.add(rightSorted.get(j));
                j++;
            }
        }

        while(i<leftSorted.size()){
            sortedList.add(leftSorted.get(i));
            i++;
        }

        while(j<rightSorted.size()){
            sortedList.add(rightSorted.get(j));
            j++;
        }
        return sortedList;

    }
}
