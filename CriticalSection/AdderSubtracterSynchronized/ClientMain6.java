import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain6 {
    public static void main(String[] args) {

          // issues I am always getting 0 ??????????????????????????????????????????

        Count1 count= new Count1();
        Add1 add = new Add1(count);
        Subtract1 sub= new Subtract1(count);
        ExecutorService exs= Executors.newCachedThreadPool();
        exs.submit(add);
        exs.submit(sub);
        System.out.println(count.value);
        exs.shutdown();
    }
}
