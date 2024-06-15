import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MainClasses {



    public static void main(String[] args) {
        Semaphore hydrogenSemaphore = new Semaphore(2);
        Semaphore oxygenSemaphore= new Semaphore(0);

        Hydrogen hydrogen= new Hydrogen(hydrogenSemaphore,oxygenSemaphore);
        Oxygen oxygen= new Oxygen(hydrogenSemaphore,oxygenSemaphore);
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        executorService.submit(hydrogen);
        executorService.submit(oxygen);
        executorService.shutdown();

    }
}
