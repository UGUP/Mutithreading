import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {

    private int maxSize=0;
    Queue<Object> queue;
    private String name;

    public Producer(int maxSize,Queue<Object> queue,String name){
        this.maxSize=maxSize;
        this.queue=queue;
        this.name=name;

    }

    @Override
    public void run() {

        while(true){
            if(queue.size()<maxSize){
                System.out.println("Producer producing is "+name);
               queue.add(new Object());
            }
        }
    }
}
