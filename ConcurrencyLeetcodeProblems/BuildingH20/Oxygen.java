import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;

public class Oxygen implements Runnable{
    private Semaphore oxygenSemaphore;
    private Semaphore hydrogenSemaphore;

    public Oxygen(Semaphore hydrogenSemaphore , Semaphore oxygenSemaphore){
        this.hydrogenSemaphore = hydrogenSemaphore;
        this.oxygenSemaphore =oxygenSemaphore;
    }

    @Override
    public void run() {
        for(int i=1;i<=10;i++) {
            try {
                oxygenSemaphore.acquire();
                System.out.print("O");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            hydrogenSemaphore.release();
            hydrogenSemaphore.release();
        }
    }
}
