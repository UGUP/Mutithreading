
import lombok.Synchronized;

import java.util.LinkedList;
import java.util.Queue;

class Consumer1 implements Runnable {


    private int maxSize=0;
    Queue<Object> queue= new LinkedList<>();
    private String name;

    public Consumer1(int maxSize, Queue<Object> queue, String name){
        this.maxSize=maxSize;

        this.queue=queue;
        this.name=name;

    }

    @Override
    public void run() {

        while(true){
            synchronized(queue){
                if(queue.size()>0){
                    System.out.println("Consumer consuming is "+" size of the queue "+queue.size());
                    queue.remove();
                }
            }
        }
    }
}
