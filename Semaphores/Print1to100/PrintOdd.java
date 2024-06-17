import java.util.concurrent.Semaphore;

public class PrintOdd implements Runnable{

    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public PrintOdd(Semaphore oddSemaphore,Semaphore evenSemaphore){
        this.evenSemaphore=evenSemaphore;
        this.oddSemaphore= oddSemaphore;
    }

    @Override
    public void run() {
        try {
            oddSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(Counter.count<=100){
            System.out.println(Counter.count+"   odd semaphore ");
            Counter.count=Counter.count+1;
            evenSemaphore.release();
        }

    }
}
