
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Consumer2 implements Runnable {


    private int maxSize=0;
    Queue<Object> queue= new LinkedList<>();
    private String name;
    private Semaphore producerS;
    private Semaphore consumerS;

    public Consumer2(int maxSize, Queue<Object> queue, String name,Semaphore producerS,Semaphore consumerS){
        this.maxSize=maxSize;
        this.consumerS=consumerS;
        this.producerS=producerS;
        this.queue=queue;
        this.name=name;

    }

    @Override
    public void run() {

        while(true){
                try {
                    consumerS.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Producer producing is "+name+" size of the queue "+queue.size());
                queue.remove();
                producerS.release();
            }
        }
    }

