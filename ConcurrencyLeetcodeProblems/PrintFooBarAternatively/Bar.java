
import java.util.concurrent.Semaphore;

public class Bar implements  Runnable{

    private Semaphore foo;
    private Semaphore bar;

    public Bar(Semaphore foo, Semaphore bar){
        this.foo=foo;
        this.bar=bar;
    }
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                bar.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("bar");
            foo.release();
        }
    }
}
