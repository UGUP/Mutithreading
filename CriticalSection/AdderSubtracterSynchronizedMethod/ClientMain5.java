import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain5 {
    public static void main(String[] args) {

        // How it can work on static methods ???? it works on object sright ???
        Count count= new Count();
        Add add = new Add(count);
        Subtract sub= new Subtract(count);
        ExecutorService exs= Executors.newCachedThreadPool();
        exs.submit(add);
        exs.submit(sub);
        exs.shutdown();
    }
}
