import java.util.concurrent.Semaphore;

public class Foo implements  Runnable{

    Semaphore first;
    Semaphore second;
    Semaphore third;

    public Foo(){
        first= new Semaphore(1);
        second= new Semaphore(0);
        third= new Semaphore(0);
    }

    public static  void first( )  {
        System.out.println("First function ");
    }

    public static void second( ) {
        System.out.println("Second function ");
    }

    public static void third( )  {
        System.out.println("Third function ");

    }

    @Override
    public void run() {
        try {
            first.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        first();
        second.release();
        try {
            second.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        second();
        third.release();
        try {
            third.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        third();
        first.release();

    }
}
