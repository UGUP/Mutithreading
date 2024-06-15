import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class NewSubtracter implements  Runnable{
    NewCount count;
    private  Lock lock;

    public NewSubtracter(NewCount count, Lock lock){
        this.count=count;
        this.lock=lock;
    }

    @Override
    public void run() {
        for(int i=0;i<=10000000;i++){
            try {
                lock.tryLock(10, TimeUnit.SECONDS);
                count.value= count.value+i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                lock.unlock();
            }

        }

    }
}
