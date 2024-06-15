
import java.util.concurrent.Semaphore;

public class Foo1 implements  Runnable{

    private Semaphore foo;
    private Semaphore bar;

    public Foo1(Semaphore foo, Semaphore bar){
        this.foo=foo;
        this.bar=bar;
    }
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            try {
                foo.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("Foo");
            bar.release();
        }
    }
}
