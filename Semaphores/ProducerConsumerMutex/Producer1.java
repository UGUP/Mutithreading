import java.util.LinkedList;
import java.util.Queue;

class Producer1 implements Runnable {

    private int maxSize=0;
    Queue<Object> queue= new LinkedList<>();
    private String name;

    public Producer1(int maxSize, Queue<Object> queue, String name){
        this.maxSize=maxSize;
        this.queue=queue;
        this.name=name;

    }

    @Override
    public void run() {

        while(true){
            synchronized (queue){
                if(queue.size()<maxSize){
                    System.out.println("Producer producing is "+name+ " size of the queue "+queue.size());
                    queue.add(new Object());
                }
            }

        }
    }
}
