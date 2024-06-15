import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class NewClient {

// Ubale to replicate the wrong scenario -------000000000

    public static void main() {
        NewCount count= new NewCount();
        Lock lock = new ReentrantLock();

        NewSubtracter sub= new NewSubtracter(count,lock);
        NewAdder add= new NewAdder(count,lock);
        ExecutorService exe= Executors.newCachedThreadPool();
        exe.submit(add);
        exe.submit(sub);
        System.out.println(count.value);
        exe.shutdown();

    }
}
