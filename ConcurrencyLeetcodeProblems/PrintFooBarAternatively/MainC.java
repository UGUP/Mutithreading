import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainC {

    public static void main(String[] args) {
        FooBar foobar= new FooBar();
//        ExecutorService se= Executors.newCachedThreadPool();
//        se.submit(foobar);
          Thread t1= new Thread(foobar);
          t1.start();
    }
}
