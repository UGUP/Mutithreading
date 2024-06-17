import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main3 {

    public static void main(String[] args) {

        Semaphore oddSemaphore = new Semaphore(1);
        Semaphore evenSemaphore = new Semaphore(0);

        PrintEven even = new PrintEven(oddSemaphore, evenSemaphore);
        PrintOdd odd = new PrintOdd(oddSemaphore, evenSemaphore);

        ExecutorService service = Executors.newFixedThreadPool(5);
        while(Counter.count<=100){
            service.submit(odd);
            service.submit(even);
        }

        service.shutdown();

    }
}
