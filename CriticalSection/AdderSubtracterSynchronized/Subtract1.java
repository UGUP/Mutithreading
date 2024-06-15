public class Subtract1 implements  Runnable{

    private Count1 count;

    public Subtract1(Count1 count){
        this.count=count;
    }

    @Override
    public void run() {
        for(int i=0;i<=1000000000;i++){
            synchronized (count){
                count.value=count.value-i;
           }
        }
    }
}
