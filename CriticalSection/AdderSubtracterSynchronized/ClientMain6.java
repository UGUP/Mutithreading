import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientMain6 {
    public static void main(String[] args) {

          // issues I am always getting 0 ??????????????????????????????????????????

        Count1 count= new Count1();
        Add1 add = new Add1(count);
        Subtract1 sub= new Subtract1(count);
        ExecutorService exs= Executors.newFixedThreadPool(10);
        exs.submit(add);
        exs.submit(sub);
        exs.submit(add);
        exs.submit(sub);
//        Thread t1= new Thread(add);
//        t1.start();
//        Thread t2= new Thread(sub);
//        t2.start();
//        Thread t3= new Thread(add);
//        t3.start();
//        Thread t4= new Thread(sub);
//
        System.out.println(count.value);
        exs.shutdown();
    }
}
