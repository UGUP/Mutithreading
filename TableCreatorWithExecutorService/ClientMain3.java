import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain3 {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        for(int i=1;i<=10;i++){
            TableCreatorWithExecutor tablecreator= new TableCreatorWithExecutor(2,i);
            executorService.submit(tablecreator);
        }

        executorService.shutdown();
    }
}
