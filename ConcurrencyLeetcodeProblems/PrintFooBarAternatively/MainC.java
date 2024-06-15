import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class MainC {

    public static void main(String[] args) {
        Semaphore fooS = new Semaphore(1);
        Semaphore barS= new Semaphore(0);

        Foo1 foo= new Foo1(fooS,barS);
        Bar bar= new Bar(fooS,barS);
        ExecutorService se= Executors.newCachedThreadPool();
        se.submit(foo);
        se.submit(bar);
        se.shutdown();

    }
}
