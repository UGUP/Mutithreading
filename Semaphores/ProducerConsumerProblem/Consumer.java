
import java.util.LinkedList;
import java.util.Queue;

class Consumer implements Runnable {


    Queue<Object> queue;
    private String name;

    public Consumer(Queue<Object> queue,String name){
        this.queue=queue;
        this.name=name;

    }

    @Override
    public void run() {

        while(true){
            if(queue.size()>0){
                System.out.println("Producer producing is "+" size of the queue "+queue.size());
                queue.remove();
            }
        }
    }
}
