import javax.management.monitor.CounterMonitorMBean;
import java.util.concurrent.Semaphore;

public class PrintEven implements Runnable{

    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public PrintEven(Semaphore oddSemaphore,Semaphore evenSemaphore){
        this.evenSemaphore=evenSemaphore;
        this.oddSemaphore= oddSemaphore;
    }

    @Override
    public void run() {
        try {
            evenSemaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(Counter.count<=100){
            System.out.println(Counter.count+" Even semphore ");
            Counter.count=Counter.count+1;
            oddSemaphore.release();
        }

    }
}
