import java.util.concurrent.Semaphore;

public class Hydrogen implements Runnable{
    private Semaphore oxygenSemaphore;
    private Semaphore hydrogenSemaphore;
    private int hydrogenCount=0;

    public Hydrogen(Semaphore hydrogenSemaphore , Semaphore oxygenSemaphore){
        this.hydrogenSemaphore= hydrogenSemaphore;
        this.oxygenSemaphore =oxygenSemaphore;
    }

    @Override
    public void run() {
        for (int i=1;i<=10;i++) {
            try {
                hydrogenSemaphore.acquire();
                System.out.print("H");
                hydrogenCount++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (hydrogenCount == 2) {
                oxygenSemaphore.release();
                hydrogenCount = 0;
            }
        }
    }
}
