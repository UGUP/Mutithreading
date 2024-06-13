import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewClient {

// Ubale to replicate the wrong scenario -------000000000

    public static void main() {
        NewCount count= new NewCount();
        NewSubtracter sub= new NewSubtracter(count);
        NewAdder add= new NewAdder(count);
        ExecutorService exe= Executors.newCachedThreadPool();
        exe.submit(add);
        exe.submit(sub);
        System.out.println(count.value);
        exe.shutdown();

    }
}
